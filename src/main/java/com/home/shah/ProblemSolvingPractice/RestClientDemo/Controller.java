package com.home.shah.ProblemSolvingPractice.RestClientDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beeceptor")
public class Controller {


    private BeeceptorService beeceptorService;

    public Controller(BeeceptorService beeceptorService) {
        this.beeceptorService = beeceptorService;
    }

    @GetMapping("/posts/{post_id}")
    public ResponseEntity<Beeceptor> getBeeceptor(@PathVariable String post_id) {
        return ResponseEntity.ok(beeceptorService.getPosts(post_id));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Beeceptor>> getBeeceptor() {
        return ResponseEntity.ok(beeceptorService.getAllPosts());
    }

    @GetMapping("/companies")
    public Companies getCompanies() {
        return beeceptorService.getAllCompanies().block();
    }
}
