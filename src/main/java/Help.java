import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Help {

    public static String ifRepaymentToStr(Cell cell) {
        if (cell == null) {
            return "0";
        }
        String f = cell.getStringCellValue();
        if ("已回款".equals(f)) {
            return "1";
        } else {
            return "0";
        }
    }

    public static String dateFormat(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            Date javaDate = cell.getDateCellValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(javaDate);
        }
        return null;
    }

    public static double amountToDouble(Cell cell) {
        cell.setCellType(CellType.STRING);
        String amount = cell.getStringCellValue();
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            // 打印错误信息，并返回默认值或者抛出异常
            throw new IllegalArgumentException("输入字符串不是一个有效的double值", e);
        }
    }

    public static int periodToInt(Cell cell) {
        String period = cell.getStringCellValue();
        switch (period) {
            case "第一期":
                return 1;
            case "第二期":
                return 2;
            case "第三期":
                return 3;
            case "第四期":
                return 4;
            case "第五期":
                return 5;
            case "第六期":
                return 6;
            case "第七期":
                return 7;
            case "第八期":
                return 8;
            case "第九期":
                return 9;
            case "第十期":
                return 10;
            case "第十一期":
                return 11;
            case "第十二期":
                return 12;
            case "第十三期":
                return 13;
            case "第十四期":
                return 14;
            case "第十五期":
                return 15;
            case "第十六期":
                return 16;
            case "第十七期":
                return 17;
            case "第十八期":
                return 18;
            case "第十九期":
                return 19;
            case "第二十期":
                return 20;
            case "第二十一期":
                return 21;
            case "第二十二期":
                return 22;
            case "第二十三期":
                return 23;
            case "第二十四期":
                return 24;
            case "第二十五期":
                return 25;
            case "第二十六期":
                return 26;
            case "第二十七期":
                return 27;
            case "第二十八期":
                return 28;
            case "第二十九期":
                return 29;
            case "第三十期":
                return 30;
            case "第三十一期":
                return 31;
            case "第三十二期":
                return 32;
            default:
                throw new IllegalArgumentException("输入字符串不是一个有效的期数");
        }
    }

}
