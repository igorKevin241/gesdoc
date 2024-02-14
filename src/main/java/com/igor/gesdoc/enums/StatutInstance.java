package com.igor.gesdoc.enums;

public enum StatutInstance {
    OUVERT("OUVERT"),
    FERME("FERME");
    private final String value;

    StatutInstance(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
