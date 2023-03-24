package com.example.restservice.consumingrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/webclient")
public class FetchQuoteWebClientController {

    @Value("${myapp.quotes.host}")
    private String host;

    private final WebClient webClient;

    public FetchQuoteWebClientController(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    @GetMapping("/quotes/random")
    public Quote fetchRandomQuote() {
        return webClient
                .get()
                .uri(host + "/api/random")
                .retrieve()
                .bodyToMono(Quote.class)
                .block();
    }

    @GetMapping("/quotes/{id}")
    public Quote fetchOneQuote(@PathVariable Long id) {
        return webClient
                .get()
                .uri(host + "/api/" + id)
                .retrieve()
                .bodyToMono(Quote.class)
                .block();
    }

    @GetMapping("/quotes")
    public List<Quote> fetchAllQuotes() {
        return webClient
                .get()
                .uri(host + "/api")
                .retrieve()
                .bodyToFlux(Quote.class)
                .collectList()
                .block();
    }

    @GetMapping("/quotes/random/slow")
    public Quote fetchRandomQuoteSlow() {
        return webClient
                .get()
                .uri(host + "/api/random/slow")
                .retrieve()
                .bodyToMono(Quote.class)
                .block();
    }
}
