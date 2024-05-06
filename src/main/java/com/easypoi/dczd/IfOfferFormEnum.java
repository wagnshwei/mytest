package com.easypoi.dczd;

import java.util.HashMap;
import java.util.Map;

public enum IfOfferFormEnum {

    OFFER("1", "是"),
    NON_OFFER("0", "否");

    private final String code;
    private final String value;

    private static final Map<String, String> valueToCodeMap = new HashMap<>();

    static {
        for (IfOfferFormEnum e : IfOfferFormEnum.values()) {
            valueToCodeMap.put(e.getValue(), e.getCode());
        }
    }

    IfOfferFormEnum(String code, String value) {
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
