package com.org.core.java.demo.stream.programming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C4_FindDuplicates {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "BB", "CC");
        Map<String, Long> namesCount = names
                .stream()
                .filter(x -> Collections.frequency(names, x) > 1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println("Duplicate founds for words with frequency of complete sentence: " + namesCount);
        System.out.println("==========================================================================================");


        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet();
        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(e-> System.out.println("Duplicate elements in a given integers list:: " + e));
        System.out.println("==========================================================================================");

    }
}
