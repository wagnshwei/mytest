package com.easypoi.dczd;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DurationUtils {

    /**
     * java.sql.Date
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDurationBetween2Date(Date startDate, Date endDate) {
        LocalDate sd = startDate.toLocalDate();
        LocalDate ed = endDate.toLocalDate();

        Period period = Period.between(sd, ed);

        return period.getDays();
    }

    /**
     * string
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDurationBetween2Date(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime1 = LocalDateTime.parse(startDate, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(endDate, formatter);

        Duration duration = Duration.between(dateTime1, dateTime2);

        return duration.toDays();
    }

    /**
     * java.util.Date
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDurationBetween2Date(java.util.Date startDate, java.util.Date endDate) {

        // 将Date转为LocalDate
        LocalDate localDate1 = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 计算天数差值
        long daysBetween = ChronoUnit.DAYS.between(localDate1, localDate2);
        return daysBetween;
    }

}
