package com.igor.gesdoc.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private CodeErreur codeErreur;
    @Getter
    private List<String> erreurs;

    public InvalidEntityException(String message){
        super();
    }

    public InvalidEntityException(String message, Throwable cause){
        super();
    }

    public InvalidEntityException(String message, Throwable cause, CodeErreur codeErreur){
        super();
        this.codeErreur = codeErreur;
    }

    public InvalidEntityException(String message, CodeErreur codeErreur){
        super();
        this.codeErreur = codeErreur;
    }
    public InvalidEntityException(String message, CodeErreur codeErreur, List<String> erreurs){
        super();
        this.codeErreur = codeErreur;
        this.erreurs = erreurs;
    }
}
