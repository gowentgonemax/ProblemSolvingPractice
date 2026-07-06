package com.home.shah.ProblemSolvingPractice.ConceptualProblem.JavaStreamAPI;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {


    public static void main(String[] args) {

        Predicate<Integer> mySum = x-> (x%2)==0;
        System.out.println(mySum.test(20));
        Function<Integer,Integer>  myFun =  x-> x*3;
        System.out.println(myFun.apply(3));
        Consumer<Integer> myCons = System.out::println;
        myCons.accept(4);
        Supplier<String> mySup  =()-> "Dude";
        System.out.println(mySup.get());
    }
}
