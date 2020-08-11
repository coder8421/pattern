package com.example.demo.responsibilityChain;

public enum washCarEnum {


    ONE("one", "1"),

    TWO("two", "2"),

    THREE("three", "3"),

    FOUR("four", "4"),

    FIVE("five", "5"),

    SIX("six", "6"),
    SEVEN("seven","7"),

    ;
    /**
     * 码
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;

    private washCarEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public static String getDesc(String code) {
        for (washCarEnum auditTypeEnum : values()) {
            if (auditTypeEnum.getCode().equals(code)) {
                return auditTypeEnum.getDesc();
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return desc;
    }
}
