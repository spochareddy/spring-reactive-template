package com.sindallah.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Configuration
public class ProductClient {

    private final WebClient client;
    public ProductClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("api/v1/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

    }
}
