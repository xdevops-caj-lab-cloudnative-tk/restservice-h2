package com.example.restservice.consumingrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class FetchQuoteController {

    private final RestTemplate restTemplate;

    @Value("${myapp.quotes.host}")
    private String host;

    public FetchQuoteController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/quotes/random")
    public Quote fetchRandomQuote() {
        String uri = host + "/api/random";
        return restTemplate.getForObject(uri, Quote.class);
    }

    @GetMapping("/quotes/{id}")
    public Quote fetchOneQuote(@PathVariable Long id) {
        String uri = host + "/api/" + id;
        return restTemplate.getForObject(uri, Quote.class);
    }

    @GetMapping("/quotes")
    public List<Quote> fetchAllQuotes() {
        String uri = host + "/api";
        Quote[] quotes = restTemplate.getForEntity(uri, Quote[].class).getBody();
        return Arrays.asList(quotes);
    }

    @GetMapping("/quotes/random/slow")
    public Quote fetchRandomQuoteSlow() {
        String uri = host + "/api/random/slow";
        return restTemplate.getForObject(uri, Quote.class);
    }
}
