package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Implement a method to find the distinct elements in a list using Java 8 streams.
public class C9_DistinctElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 5);

        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct elements: " + distinct);
    }
}
