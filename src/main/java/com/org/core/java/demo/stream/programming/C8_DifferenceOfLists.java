package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Implement a method to find the difference between two lists using Java 8 streams.
public class C8_DifferenceOfLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> difference = list1.stream()
                .filter(num -> !list2.contains(num))
                .collect(Collectors.toSet());

        System.out.println("Difference of lists: " + difference);
    }
}
