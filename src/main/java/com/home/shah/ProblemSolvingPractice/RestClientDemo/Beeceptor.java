package com.home.shah.ProblemSolvingPractice.RestClientDemo;

import lombok.Getter;

@Getter
public class Beeceptor {
    private String userId;
    private String id;
    private String title;
    private String body;
    private String link;
    private int comment_count;

    // Explicit getter added to ensure the method reference Beeceptor::getTitle
    // is available to the compiler even if Lombok annotation processing is
    // not active in the build environment.
    public String getTitle() {
        return this.title;
    }
}
