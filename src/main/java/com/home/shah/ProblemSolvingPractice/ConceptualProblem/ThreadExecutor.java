package com.home.shah.ProblemSolvingPractice.ConceptualProblem;

import org.apache.tomcat.util.threads.InlineExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3); {
            for (int i = 0; i <10; i++) {
                int finalI = i;
                executorService.submit(() -> {
                    long result = finalI*2;
                    System.out.println(result);
                });
            }
        }
    }
}
