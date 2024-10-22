package com.aiquizgenerator.backend.models;

import lombok.Value;

@Value
public class ErrorMessage {

    private String message;

    public static ErrorMessage from(final String message) {
        return new ErrorMessage(message);
    }
}
