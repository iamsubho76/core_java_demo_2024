package com.org.core.java.demo.stream.programming;

import java.util.stream.Stream;

//Implement a method to find the nth Fibonacci number using Java 8 streams.
public class C24_NthFibonacciNumber {
    public static void main(String[] args) {
        int n = 8;

        int fibonacci = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(n)
                .reduce((a, b) -> b)
                .orElse(new int[]{0, 0})[0];

        System.out.println("Nth Fibonacci number: " + fibonacci);
    }
}
