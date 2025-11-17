package com.home.shah.ProblemSolvingPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProblemSolvingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProblemSolvingPracticeApplication.class, args);
	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder()
				.baseUrl("https://json-placeholder.mock.beeceptor.com" )
				.build();
	}

	@Bean
	public RestClient restClient(){
		return RestClient.builder()
				.baseUrl("https://json-placeholder.mock.beeceptor.com" )
				.build();
	}

}
