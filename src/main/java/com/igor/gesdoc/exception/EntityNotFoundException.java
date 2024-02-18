package com.igor.gesdoc.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    @Getter
    private CodeErreur codeErreur;

    public EntityNotFoundException(String message){
        super();
    }

    public EntityNotFoundException(String message, Throwable cause){
        super();
    }

    public EntityNotFoundException(String message, Throwable cause, CodeErreur codeErreur){
        super();
        this.codeErreur = codeErreur;
    }

    public EntityNotFoundException(String message, CodeErreur codeErreur){
        super();
        this.codeErreur = codeErreur;
    }


}
