import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCExample {

    public static String url = "jdbc:mysql://localhost:3306/hussar?useSSL=false&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "root";

    public static String excelFilePath = "C:\\Users\\HP\\Desktop\\历史数据统计2024.2.17.xlsx";

    public static HashMap<String, Long> sheetIdMap = new HashMap<>();
    static {
        sheetIdMap.put("2.黄河交通学院",2L);
        sheetIdMap.put("3.开慧教育",3L);
        sheetIdMap.put("4.欧亚新材料",4L);
        sheetIdMap.put("5.临沂河东医院",5L);
//        sheetMap.put("6.华瑞园二期",6L);
        sheetIdMap.put("7.鲁维制药",7L);
        sheetIdMap.put("8.润华集团",8L);
        sheetIdMap.put("9.诸城外贸",9L);
        sheetIdMap.put("10.平阴县人民医院",10L);
        sheetIdMap.put("11.慧智新材料",11L);
    }

    public static void main(String[] args) throws Exception {
        for(Map.Entry entry : sheetIdMap.entrySet()) {
            List<PaymentRecord> readExcelSheet = readExcelSheet(excelFilePath, entry.getKey().toString(), (long)entry.getValue());
            insertToDB(readExcelSheet);
        }
    }

    public static void insertToDB(List<PaymentRecord> lists) {

        String sql = "INSERT INTO rzzl_lease_detail (customer_id, project_id, repayment_period, receivable_principal, receivable_interest, receivable_total_amount, receivable_surplus_principal, receivable_repayment_date, receivable_lease_rate, receivable_earnings_rate, if_repayment, actual_repayment_principal, actual_repayment_interest, actual_surplus_principal, actual_total_amount, actual_repayment_date, create_time, create_user_id, update_time, update_user_id, delete_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for(PaymentRecord record:lists) {
                // 设置每个占位符的值，数据类型应与列定义匹配
                pstmt.setLong(1, /* 客户id值 */ 2L);
                pstmt.setLong(2, /* 立项id值 */ 2L);
                pstmt.setInt(3, /* 还款期数，2代表第2期 */ record.getRepayment_period());
                pstmt.setBigDecimal(4, /* 应收本金值 */ new BigDecimal(record.getReceivable_principal()));
                pstmt.setBigDecimal(5, /* 应收利息值 */ new BigDecimal(record.getReceivable_interest()));
                pstmt.setBigDecimal(6, /* 应收总计值 */ new BigDecimal(record.getReceivable_total_amount()));
                pstmt.setBigDecimal(7, /* 应剩余本金值 */ new BigDecimal(record.getReceivable_surplus_principal()));
                pstmt.setDate(8, /* 应回款日期值 */ java.sql.Date.valueOf(record.getReceivable_repayment_date()));
                pstmt.setBigDecimal(9, /* 应租赁利率值 */ null);
                pstmt.setBigDecimal(10, /* 应收益率值 */ null);
                pstmt.setString(11, /* 是否回款值 */ record.getIf_repayment());
                pstmt.setBigDecimal(12, /* 实际还款本金值 */ null);
                pstmt.setBigDecimal(13, /* 实际还款利息值 */ null);
                pstmt.setBigDecimal(14, /* 实际剩余本金值 */ null);
                pstmt.setBigDecimal(15, /* 实际还款总额值 */ null);
                pstmt.setDate(16, /* 实际回款日期值 */ null);
                pstmt.setTimestamp(17, /* 创建时间值 */ null);
                pstmt.setLong(18, /* 创建人id值 */ 0L);
                pstmt.setTimestamp(19, /* 修改时间值 */ null);
                pstmt.setLong(20, /* 修改人id值 */ 0L);
                pstmt.setString(21, /* 是否删除值 */ "0");

                // 执行语句
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("插入行数：" + rowsAffected);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 如果使用try-with-resources语法，资源会在try代码块执行完毕后自动关闭
    }

    public static List<PaymentRecord> readExcelSheet(String excelFilePath, String sheetName, long id) throws Exception {
        try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("没有找到名为 '" + sheetName + "' 的表单");
            }

            // 用来存储列名和对应的列索引
            Map<String, Integer> columnMap = new HashMap<>();
            // 是否是第一行（标题行）
            boolean isFirstRow = true;

            List<PaymentRecord> lists = new ArrayList<>();

            for (Row row : sheet) {
                if (isFirstRow) {
                    // 读取标题行并构建列名和索引的映射
                    for (Cell cell : row) {
                        int columnIndex = cell.getColumnIndex();
                        String columnName = cell.getStringCellValue();
                        columnMap.put(columnName, columnIndex);
                    }
                    isFirstRow = false;
                } else {
                    // 读取数据行，并通过列名来访问值
                    // 序号 期数 租金支付通知书寄送日期 是否寄送 应收本金 应收利息 合计租金 剩余本金 回款日期 是否为节假日 是否回款
                    PaymentRecord record = new PaymentRecord();
                    record.setCustomer_id(id);
                    record.setProject_id(id);

                    Cell repayment_period = row.getCell(columnMap.get("期数"));
                    record.setRepayment_period(Help.periodToInt(repayment_period));
                    Cell receivable_principal = row.getCell(columnMap.get("应收本金"));
                    record.setReceivable_principal(Help.amountToDouble(receivable_principal));
                    Cell receivable_interest = row.getCell(columnMap.get("应收利息"));
                    record.setReceivable_interest(Help.amountToDouble(receivable_interest));
                    Cell receivable_total_amount = row.getCell(columnMap.get("合计租金"));
                    record.setReceivable_total_amount(Help.amountToDouble(receivable_total_amount));
                    Cell receivable_surplus_principal = row.getCell(columnMap.get("剩余本金"));
                    record.setReceivable_surplus_principal(Help.amountToDouble(receivable_surplus_principal));
                    Cell receivable_repayment_date = row.getCell(columnMap.get("回款日期"));
                    record.setReceivable_repayment_date(Help.dateFormat(receivable_repayment_date));
                    Cell if_repayment = row.getCell(columnMap.get("是否回款"));
                    record.setIf_repayment(Help.ifRepaymentToStr(if_repayment));

                    lists.add(record);
                }
            }
            return lists;
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }

}
