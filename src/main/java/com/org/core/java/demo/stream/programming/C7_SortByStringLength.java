package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Write a program to sort a list of strings by their lengths in descending order using Java 8 streams.
public class C7_SortByStringLength {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "strawberry", "pineapple");

        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .collect(Collectors.toList());

        System.out.println("Strings sorted by length: " + sorted);


//        int arr[] = { 99, 55, 203, 99, 4, 91 };
//        Arrays.parallelSort(arr);
//        // Sorted the Array using parallelSort()
//
//        Arrays.stream(arr).forEach(n > System.out.print(n + " "));
//        /* Converted it into Stream and then
//           printed using forEach */



/*        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);*/
    }
}
