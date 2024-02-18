package com.igor.gesdoc.enums;

public enum StatutExonerationEnum {
    NON_TRAITEE("NON_TRAITEE"),
    TRAITEE("TRAITEE"),
    REJETEE("REJETEE");
    private final String value;
    StatutExonerationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
