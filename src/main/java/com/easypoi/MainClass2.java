package com.easypoi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainClass2 {

    public static List<ExcelExportEntity> makeOrders() {
        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
//构造对象等同于@Excel
        ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
        excelentity.setNeedMerge(true);
        entity.add(excelentity);
        entity.add(new ExcelExportEntity("性别", "sex"));
        excelentity = new ExcelExportEntity(null, "students");
        List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
        temp.add(new ExcelExportEntity("姓名", "name"));
        temp.add(new ExcelExportEntity("性别", "sex"));
//构造List等同于@ExcelCollection
        excelentity.setList(temp);
        entity.add(excelentity);
        return entity;
    }

    public static void main(String[] args) throws IOException {
        test();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("订单报表", "2024年"), makeOrders(), new ArrayList<Map<String, Object>>());
        FileOutputStream fos = new FileOutputStream("D:\\test\\订单报表.xlsx");
        workbook.write(fos);
        fos.close();
    }

    public static void test() {
        try {
            List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
//构造对象等同于@Excel
            ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
            excelentity.setNeedMerge(true);
            entity.add(excelentity);
            entity.add(new ExcelExportEntity("性别", "sex"));
            excelentity = new ExcelExportEntity(null, "students");
            List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
            temp.add(new ExcelExportEntity("姓名", "name"));
            temp.add(new ExcelExportEntity("性别", "sex"));
//构造List等同于@ExcelCollection
            excelentity.setList(temp);
            entity.add(excelentity);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//把我们构造好的bean对象放到params就可以了
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), entity,
                    list);
            FileOutputStream fos = new FileOutputStream("D:/ExcelExportForMap.tt.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
