package com.aiquizgenerator.backend.models;

import lombok.Value;

@Value
public class Message {

    private String text;

    public static Message from(final String text) {
        return new Message(text);
    }
}
