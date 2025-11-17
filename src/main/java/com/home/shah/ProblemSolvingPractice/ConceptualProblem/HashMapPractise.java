package com.home.shah.ProblemSolvingPractice.ConceptualProblem;

import java.util.HashMap;

public class HashMapPractise {

    public static void main(String[] args) {
        HashMap<String,Integer> friends = new HashMap<>();
        friends.put(" Nitesh" ,34);
        friends.put(" Ankit" ,44);
        friends.put(null,44);
        friends.put(null,34);
        System.out.println(friends);
    }
//    put(){
//       int hash = hashCode(k);
//       int  index =  hash&(n-1);
//    }

    //When null key is given, it is stored at Zero Index.
    //One bucket consists of many LinkedList.
    //When Equal key, Then replaced unless, it will be redirect to next linked list
    //When Hash collisions happens then LinkedList is implemented.
    //Hashmap has threshold value is 12
    //A hash collision is a random match in hash values that occurs when a hashing algorithm produces the same hash value for two distinct pieces of data.
    //HashCollision when hash collision occurs when a hash algorithm produces the same hash value for two different input values.


}
