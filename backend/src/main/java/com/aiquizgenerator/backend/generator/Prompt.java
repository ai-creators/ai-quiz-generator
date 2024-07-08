package com.aiquizgenerator.backend.generator;


public class Prompt {

    private final String header = "Create a quiz based on the prompt,";

    private String initialPrompt;
    
    private String lengthRule;

    public Prompt(){
        lengthRule = "";
    }

    public String getContent(){
        return header + " " + initialPrompt + "." + lengthRule;
    }

    public void setLengthRule(String rule){
        lengthRule = rule;
    }

    public void setInitialPrompt(String initialPrompt) {
        this.initialPrompt = initialPrompt;
    }
}
