package com.aiquizgenerator.backend.quiz.dto.request;

import jakarta.validation.constraints.Size;

public class CreateQuizDto {
    @Size(max = 50, message = "A prompt can be at most 50 characters")
    @Size(min = 1 , message = "A prompt must be at least one character")
    private String prompt;

    public String getPrompt(){
        return prompt;
    }
}
