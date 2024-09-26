package com.easypoi.dczd;

import org.apache.commons.lang3.StringUtils;

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

    public static void constructBankLeaseInfo(Entity entity) {
        String leaseInfo = "[";
        boolean removeComma = false;
        for(Entity child : entity.getChildren()) {
            if(child.getOriginalLoanAmount() != null) {
                removeComma = true;
                leaseInfo += "{\"leaseAmount\":" + child.getOriginalLoanAmount() + "," + "\"expireDate\":\"" + child.getApplyLoanEndTime() + "\"},";
            }
        }
        if(removeComma) {
            entity.setLeaseInfo(leaseInfo.substring(0, leaseInfo.length()-1)+"]");
        } else {
            entity.setLeaseInfo(leaseInfo+"]");
        }
    }

    public static void initializeEntity(Entity entity) {
        entity.setApplyLoanEndTime(Helper.formatDateString(entity.getApplyLoanEndTime()));
        entity.setApplyLoanStartTime(Helper.formatDateString(entity.getApplyLoanStartTime()));
//        entity.setLeaseInfo(Helper.constructBankLeaseInfo(entity.getOriginalLoanAmount(), entity.getApplyLoanEndTime()));
        entity.setIfSettle(IfSettleEnum.getCodeByValue(trimString(entity.getIfSettle())));
        entity.setIfLoan(getIfLoan(entity.getIndex(), entity.getIfLoan()));
        entity.setIfBankOfferContractForm(IfOfferFormEnum.getCodeByValue(entity.getIfBankOfferContractForm()));
    }

    public static String trimString(String value) {
        return value == null ? value : value.trim();
    }

    public static String getIfLoan(String index, String ifLoan) {
        if(StringUtils.isNotEmpty(ifLoan)) {
            return IfLoanEnum.getCodeByValue(trimString(ifLoan));
        }
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
