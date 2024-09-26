package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DateConverter {

    // 默认日期格式
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 将字符串转换为 Date 对象，默认格式为 "yyyy-MM-dd"。
     *
     * @param dateString 字符串形式的日期
     * @return 转换后的 Date 对象
     */
    public static Date convertToDate(String dateString) {
        return convertToDate(dateString, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串转换为 Date 对象，指定日期格式。
     *
     * @param dateString 字符串形式的日期
     * @param dateFormat 日期格式字符串
     * @return 转换后的 Date 对象
     */
    public static Date convertToDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString, e);
        }
    }

    /**
     * 将 Date 对象转换为字符串，默认格式为 "yyyy-MM-dd"。
     *
     * @param date Date 对象
     * @return 转换后的字符串
     */
    public static String convertToString(Date date) {
        return convertToString(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将 Date 对象转换为字符串，指定日期格式。
     *
     * @param date       Date 对象
     * @param dateFormat 日期格式字符串
     * @return 转换后的字符串
     */
    public static String convertToString(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    // 测试方法
    public static void main(String[] args) {
        // 使用默认格式转换
        String dateString1 = "2023-09-01";
        Date date1 = DateConverter.convertToDate(dateString1);
        System.out.println("Default format: " + date1);

        // 使用自定义格式转换
        String dateString2 = "01-09-2023";
        Date date2 = DateConverter.convertToDate(dateString2, "dd-MM-yyyy");
        System.out.println("Custom format: " + date2);

        // 将 Date 转换为字符串，默认格式
        Date currentDate = new Date();
        String formattedDate1 = DateConverter.convertToString(currentDate);
        System.out.println("Formatted date (default): " + formattedDate1);


        // 将 Date 转换为字符串，自定义格式
        String formattedDate2 = DateConverter.convertToString(currentDate, "dd/MM/yyyy");
        System.out.println("Formatted date (custom): " + formattedDate2);
//        HashMap
    }
}
