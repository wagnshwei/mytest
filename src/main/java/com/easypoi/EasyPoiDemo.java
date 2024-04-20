package com.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import cn.afterturn.easypoi.excel.annotation.Excel;

public class EasyPoiDemo {

    public static void main(String[] args) throws IOException {
        // 创建数据列表
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(25);
        userList.add(user1);
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(30);
        userList.add(user2);

        // 设置导出参数
        ExportParams exportParams = new ExportParams("用户列表", "用户信息");

        // 导出Excel
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, userList);
        try (FileOutputStream fos = new FileOutputStream("D:\\test\\user_list.xlsx")) {
            workbook.write(fos);
            System.out.println("Excel文件导出成功！");
        }
    }
}



class User {
    @Excel(name = "姓名", width = 15)
    private String name;

    @Excel(name = "年龄", width = 10)
    private Integer age;

    // 省略getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}