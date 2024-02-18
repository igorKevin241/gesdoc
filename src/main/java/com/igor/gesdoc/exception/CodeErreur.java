package com.igor.gesdoc.exception;

public enum CodeErreur {
    ELEMENT_AJOUTE_AVEC_SUCCES(200),
    FORMAT_DE_DONNEE_INCORRET(400),
    ERREUR_INTERNE(500);

    private final int code;

    CodeErreur(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
