package com.org.core.java.demo.stream.programming;

import java.util.*;

//Implement a method to find the maximum number in a list of integers using Java 8 streams.
public class C2_MaxNumberFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 15);

        int max = numbers.stream()
                .max(Integer::compare)
                .orElse(-1);

        System.out.println("Maximum number in list: " + max);


        int[] arr = {12,19,20,88,00,9};
        int asIntMax = Arrays.stream(arr).max().getAsInt();

        System.out.println("Maximum number in array: " + asIntMax);
    }
}
