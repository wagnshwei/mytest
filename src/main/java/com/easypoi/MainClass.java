package com.easypoi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static List<Order> makeOrders() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderId("1");
        order.setOrderName("电子产品订单");

        List<OrderDetail> details = new ArrayList<>();
        OrderDetail detail1 = new OrderDetail();
        detail1.setProductId("A001");
        detail1.setProductName("手机");
        detail1.setQuantity(10);

        OrderDetail detail2 = new OrderDetail();
        detail2.setProductId("A002");
        detail2.setProductName("笔记本电脑");
        detail2.setQuantity(5);

        details.add(detail1);
        details.add(detail2);

        order.setOrderDetails(details);
        orders.add(order);
        return orders;
    }

    public static void main(String[] args) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("test", "test"), Order.class, makeOrders());
        FileOutputStream fos = new FileOutputStream("D:\\test.xls");
        workbook.write(fos);
        fos.close();
    }

}
