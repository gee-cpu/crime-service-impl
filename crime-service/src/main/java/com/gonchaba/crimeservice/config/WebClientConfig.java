package com.gonchaba.crimeservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "external-api")
@Data
public class WebClientConfig {

    private String uri;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().baseUrl(uri);
    }
}

