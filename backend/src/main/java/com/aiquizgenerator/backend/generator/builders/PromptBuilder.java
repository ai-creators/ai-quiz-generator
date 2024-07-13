package com.aiquizgenerator.backend.generator.builders;

import org.springframework.stereotype.Component;

import com.aiquizgenerator.backend.generator.Prompt;

@Component
public class PromptBuilder {
    private Prompt prompt;

    public void setInitialPrompt(String initialPrompt){
        prompt.setPrompt(initialPrompt);
    }

    public void setQuestionsLength(){
        prompt.setLengthRule("Set the default amount of questions to 5.");
    }

    public void setQuestionsLength(String amountOfQuestions){
        prompt.setLengthRule(amountOfQuestions);
    }

    public Prompt getPrompt(){
        return prompt;
    }
    
    public void reset(){
        prompt = new Prompt();
    }
}
