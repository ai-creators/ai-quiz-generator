package com.aiquizgenerator.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import lombok.Value;

@Value
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    String clientOriginUrl;

    String openaiModel;

    String openaiApiUrl;

    String openaiApiKey;

    @ConstructorBinding
    public ApplicationProperties(final String clientOriginUrl, final String openaiModel, final String openaiApiUrl, final String openaiApiKey) {
        this.clientOriginUrl = clientOriginUrl;
        this.openaiModel = openaiModel;
        this.openaiApiUrl = openaiApiUrl;
        this.openaiApiKey = openaiApiKey;
    }

}
