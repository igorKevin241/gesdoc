package com.igor.gesdoc.enums;

public enum SelectionEnum {
    OUI("OUI"),
    NON("NON");

    private final String value;

    SelectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
