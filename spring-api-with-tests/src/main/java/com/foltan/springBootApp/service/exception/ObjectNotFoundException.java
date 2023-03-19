package com.foltan.springBootApp.service.exception;

import java.util.function.Supplier;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
