package com.org.core.java.demo.stream.programming;

import java.util.stream.IntStream;

//Write a program to check if a given number is a prime number using Java 8 streams.
public class C27_PrimeNumberChecker {
    public static void main(String[] args) {
        int number = 17;

        boolean isPrime = number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);

        System.out.println("Is prime? " + isPrime);
    }
}
