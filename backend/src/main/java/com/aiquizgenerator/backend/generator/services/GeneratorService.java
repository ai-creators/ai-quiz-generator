package com.aiquizgenerator.backend.generator.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aiquizgenerator.backend.config.ApplicationProperties;
import com.aiquizgenerator.backend.generator.Prompt;
import com.aiquizgenerator.backend.generator.builders.PromptBuilder;
import com.aiquizgenerator.backend.generator.dto.ChatResponse;
import com.aiquizgenerator.backend.generator.dto.request.ChatRequest;
import com.aiquizgenerator.backend.quiz.dto.request.CreateQuizDto;
import com.aiquizgenerator.backend.quiz.entities.Quiz;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GeneratorService {
    
    @Qualifier("openaiRestTemplate")
    private final RestTemplate restTemplate;

    private final ApplicationProperties applicationProps;

    private final PromptBuilder promptBuilder;

    private final ObjectMapper objectMapper;

    private String chat(Prompt prompt){
        String requestBody = String.format(
            "{\n" +
            "  \"model\": \"" + applicationProps.getOpenaiModel() +"\",\n" +
            // "  \"response_format\": { \"type\": \"json_object\"},\n" +
            "  \"messages\": [\n" +
            "    {\n" +
            "      \"role\": \"user\",\n" +
            "      \"content\": \"%s\"\n" +
            "    }\n" +
            "  ],\n" +
            "}", prompt.build().replace("\"", "\\\""));

        ChatRequest request = new ChatRequest(applicationProps.getOpenaiModel(), requestBody);

        ChatResponse response = restTemplate.postForObject(applicationProps.getOpenaiApiUrl(), request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        System.out.println("Full ChatResponse: " + convertObjectToJson(response));
        
        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }

    private String convertObjectToJson(Object obj) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            return "Error converting object to JSON: " + e.getMessage();
        }
    }

    public Quiz generateQuiz(CreateQuizDto createQuizDto) {
        promptBuilder.reset();
        promptBuilder.setInitialPrompt(createQuizDto.getPrompt());
        promptBuilder.setQuestionsLength();

        System.out.println("BEFORE");

        String quizJson = chat(promptBuilder.getPrompt());

        System.out.println("AFTER");
        System.out.println("JSON: " + quizJson);

        try {
            return objectMapper.readValue(quizJson, Quiz.class);
        } catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
            throw new RuntimeException("Error creating a quiz. Try changing the prompt.");
        }
    }
}

