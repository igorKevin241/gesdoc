package com.igor.gesdoc.enums;

public enum StatutExoneration {
    NON_TRAITEE("NON_TRAITEE"),
    TRAITEE("TRAITEE"),
    REJETEE("REJETEE");
    private final String value;
    StatutExoneration(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
