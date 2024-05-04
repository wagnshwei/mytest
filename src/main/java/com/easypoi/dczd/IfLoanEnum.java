package com.easypoi.dczd;

import java.util.HashMap;
import java.util.Map;

public enum IfLoanEnum {

    SETTLED("1", "是"),
    SETTLING("0", "否");

    private final String code;
    private final String value;

    private static final Map<String, String> valueToCodeMap = new HashMap<>();

    static {
        for (IfLoanEnum e : IfLoanEnum.values()) {
            valueToCodeMap.put(e.getValue(), e.getCode());
        }
    }

    IfLoanEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getCodeByValue(String value) {
        return valueToCodeMap.get(value);
    }

}
