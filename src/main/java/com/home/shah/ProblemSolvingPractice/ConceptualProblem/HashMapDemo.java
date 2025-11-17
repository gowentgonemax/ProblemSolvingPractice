package com.home.shah.ProblemSolvingPractice.ConceptualProblem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashMapDemo {
    public static void main(String[] args) {

        //linkedHashmapDemo();
        //treeMapDemo();
        treeSetDemo();
    }

    private static void linkedHashmapDemo() {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Ravi",30);
        linkedHashMap.put("Dhavi",40);
        linkedHashMap.put("Gavi",50);
        linkedHashMap.put("Chavi",60);
        linkedHashMap.put("Baavi",36);
        linkedHashMap.put("Navi",37);

        linkedHashMap.get("Baavi");
        linkedHashMap.get("Gavi");
        System.out.println(linkedHashMap);
//        for (Integer key: linkedHashMap.sequencedValues()){
//            System.out.println(key);
//        }
    }

    private static void treeMapDemo(){

        TreeMap<String,Integer> map =new TreeMap<>();
        map.put("Ravi",30);
        map.put("Dhavi",40);
        map.put("Gavi",50);
        map.put("Chavi",60);
        map.put("Baavi",36);
        map.put("Navi",37);

        map.put(null,300); // Doesnt allow null key
        System.out.println(map);
        System.out.println(map.get(null));
    }
    private static void treeSetDemo(){
        TreeSet<String> set = new TreeSet<>();
        set.add("Guava");
        set.add("Java");
        set.add("Bava");
        set.add("Ghava");
        set.add("Dhava");
        System.out.println(set);
    }
}
