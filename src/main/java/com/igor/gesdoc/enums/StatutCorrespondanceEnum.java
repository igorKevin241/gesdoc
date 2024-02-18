package com.igor.gesdoc.enums;

public enum StatutCorrespondanceEnum {
    TRAITE("TRAITE"),
    NON_TRAITE("NON_TRAITE"),
    CLASSE("CLASSE");

    private final String value;

    StatutCorrespondanceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
