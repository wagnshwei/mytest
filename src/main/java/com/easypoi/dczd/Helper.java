package com.easypoi.dczd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {

    public static String formatDateString(String dateStr) {
        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = null;
        try{
            date = parser.parse(dateStr);
        } catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static String getNowDatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String constructBankLeaseInfo(Double origin, String date) {
        return "[{\"leaseAmount\":" + origin + "," + "\"expireDate\":\"" + date + "\"}]";
    }

    public static void initializeEntity(Entity entity) {
        entity.setApplyLoanEndTime(Helper.formatDateString(entity.getApplyLoanEndTime()));
        entity.setApplyLoanStartTime(Helper.formatDateString(entity.getApplyLoanStartTime()));
        entity.setLeaseInfo(Helper.constructBankLeaseInfo(entity.getOriginalLoanAmount(), entity.getApplyLoanEndTime()));
        entity.setIfSettle(IfSettleEnum.getCodeByValue(trimString(entity.getIfSettle())));
        entity.setIfLoan(getIfLoan(entity.getIndex()));
    }

    public static String trimString(String value) {
        return value == null ? value : value.trim();
    }

    public static String getIfLoan(String index) {
        if(index == null){
            return null;
        } else if("*".equals(trimString(index))) {
            return IfLoanEnum.getCodeByValue("否");
        } else {
            return IfLoanEnum.getCodeByValue("是");
        }
    }

    public static void printList(List<Entity> list) {
        Optional.ofNullable(list).filter(entity -> !entity.isEmpty()).ifPresent(entity -> entity.forEach(System.out::println));
    }

}
