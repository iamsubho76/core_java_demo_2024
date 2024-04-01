package com.org.core.java.demo.stream.programming;

import java.util.Arrays;
import java.util.List;

//Write a program to find the sum of squares of even numbers in a list using Java 8 streams.
public class C31_SumOfEvenSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println("Sum of squares of even numbers: " + sum);
    }
}
