package com.org.core.java.demo.stream.programming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Implement a method to find the maximum number in a list of integers using Java 8 streams.
public class C2_NthMaxNumberFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 15);

        int max = numbers.stream()
                .max(Integer::compare)
                .orElse(-1);

        System.out.println("First max number in list using max(): " + max);


        int[] arr = {12,19,20,88,100,9};
        int asIntMax = Arrays.stream(arr).max().getAsInt();

        System.out.println("First max number in array using max(): " + asIntMax);

        System.out.println("==================================================================================================================================");
        LinkedHashMap<Integer, Long> collectedData = Arrays.stream(arr)
                .boxed() // Convert int[] to Stream<Integer>
                .distinct() // Remove duplicates
                .sorted()// by default sorted is ascending(small to big)
                //.sorted((val1, val2) -> Integer.compare(val2, val1))// if you want to make it decending
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Integer secondLastData = collectedData.entrySet()
                .stream()
                .skip(Math.max(0, collectedData.size() - 2))
                .map(entry-> entry.getKey())
                .findFirst()
                .orElse(-1);

        System.out.println("Second max element:: " + secondLastData);

    }
}
