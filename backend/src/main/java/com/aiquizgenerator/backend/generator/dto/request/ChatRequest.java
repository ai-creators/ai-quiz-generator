package com.aiquizgenerator.backend.generator.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.aiquizgenerator.backend.generator.dto.Message;

public class ChatRequest {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequest(String model, String prompt) {
        this.model = model;
        n = 1;
        
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    public String getModel(){
        return model;
    }

    public List<Message> getMessages(){
        return messages;
    }

    public int getN(){
        return n;
    }

    public double getTemperature(){
        return temperature;
    }
}

