package com.igor.gesdoc.enums;

public enum StatutInstanceEnum {
    OUVERT("OUVERT"),
    FERME("FERME");
    private final String value;

    StatutInstanceEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
