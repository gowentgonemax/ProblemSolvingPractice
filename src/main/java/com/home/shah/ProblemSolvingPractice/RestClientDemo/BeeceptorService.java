package com.home.shah.ProblemSolvingPractice.RestClientDemo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BeeceptorService {
    private final RestClient client;
    private final MediaType mediaType = MediaType.APPLICATION_JSON;

    private final WebClient webClient;
    String BASE_URL = "https://json-placeholder.mock.beeceptor.com";

    public BeeceptorService(RestClient client, WebClient webClient) {
        this.client = client;
        this.webClient = webClient;
    }

    public Beeceptor getPosts(String postId){
        return client.get()
                .uri(BASE_URL + "/posts/{post_id}",postId)
                .retrieve()
                .body(Beeceptor.class);


    }
    public List<Beeceptor> getAllPosts() {
        List<Beeceptor> body = client.get()
                .uri(BASE_URL + "/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        Map<String, List<Beeceptor>> collect = Objects.requireNonNull(body).stream()
        .collect(Collectors.groupingBy(Beeceptor::getTitle));
        return body;

    }
    public Mono<Companies> getAllCompanies(){
        return webClient
                .get()
                .uri(BASE_URL, "/companies")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Companies>() {
                });
        }


}
