package com.easypoi.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) throws Exception {

        TestStudent testStudent = new TestStudent();
        testStudent.setId("1").setName("张三").setSex(1);
        TestStudent testStudent1 = new TestStudent();
        testStudent1.setId("2").setName("李四").setSex(2);
        List<TestStudent> testStudentList = new ArrayList<>();
        testStudentList.add(testStudent);
        testStudentList.add(testStudent1);

        TestTeacher testTeacher = new TestTeacher();
        testTeacher.setId("1").setName("老师1");
        TestTeacher testTeacher1 = new TestTeacher();
        testTeacher1.setId("2").setName("老师2");

        TestCour testCour = new TestCour();
        testCour.setId("1").setName("课程1").setMathTeacher(testTeacher).setStudents(testStudentList);
        TestCour testCour1 = new TestCour();
        testCour1.setId("2").setName("课程2").setMathTeacher(testTeacher).setStudents(testStudentList);
        List<TestCour> testCours = new ArrayList<>();
        testCours.add(testCour);
        testCours.add(testCour1);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
                TestCour.class, testCours);
        FileOutputStream fos = new FileOutputStream("D:/test/exportCompanyImg.xls");
        workbook.write(fos);
        fos.close();
    }
}
