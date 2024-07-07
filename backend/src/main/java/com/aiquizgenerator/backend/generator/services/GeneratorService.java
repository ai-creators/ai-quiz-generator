package com.aiquizgenerator.backend.generator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aiquizgenerator.backend.config.ApplicationProperties;
import com.aiquizgenerator.backend.generator.dto.ChatResponse;
import com.aiquizgenerator.backend.generator.dto.request.ChatRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GeneratorService {
    
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    private final ApplicationProperties applicationProps;

    private String chat(String prompt){
        ChatRequest request = new ChatRequest(applicationProps.getOpenaiModel(), prompt);

        ChatResponse response = restTemplate.postForObject(applicationProps.getOpenaiApiUrl(), request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
