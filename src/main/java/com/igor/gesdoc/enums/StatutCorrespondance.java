package com.igor.gesdoc.enums;

public enum StatutCorrespondance {
    TRAITE("TRAITE"),
    NON_TRAITE("NON_TRAITE"),
    CLASSE("CLASSE");

    private final String value;

    StatutCorrespondance(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
