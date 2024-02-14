package com.igor.gesdoc.enums;

public enum TypeProjet {
    MARCHE_DE_TRAVAUX("MARCHE_DE_TRAVAUX"),
    MARCHE_DE_BIENS("MARCHE_DE_BIENS"),
    MARCHE_DE_SERVICE("MARCHE_DE_SERVICE"),
    ACTIVITE_COURANTE("ACTIVITE_COURANTE");

    private final String value;

    TypeProjet(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
