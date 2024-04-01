package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Implement a method to find the union of two lists using Java 8 streams.
public class C12_UnionOfLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> union = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toSet());

        System.out.println("Union of lists: " + union);
    }
}
