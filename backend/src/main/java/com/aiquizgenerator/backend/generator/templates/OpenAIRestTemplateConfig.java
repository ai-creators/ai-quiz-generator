package com.aiquizgenerator.backend.generator.templates;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.aiquizgenerator.backend.config.ApplicationProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenAIRestTemplateConfig {

    private final ApplicationProperties applicationProperties;

    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + applicationProperties.getOpenaiApiKey());
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}