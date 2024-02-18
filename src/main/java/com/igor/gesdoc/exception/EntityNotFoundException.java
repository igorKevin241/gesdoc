package com.igor.gesdoc.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}



