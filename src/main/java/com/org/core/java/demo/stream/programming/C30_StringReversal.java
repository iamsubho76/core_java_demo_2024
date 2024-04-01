package com.org.core.java.demo.stream.programming;

// Implement a method to reverse a string using Java 8 streams.
public class C30_StringReversal {
    public static void main(String[] args) {
        String str = "hello";

        String reversed = new StringBuilder(str).reverse().toString();

        System.out.println("Reversed string: " + reversed);
    }
}
