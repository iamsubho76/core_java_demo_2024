package com.org.core.java.demo.stream.reduce;//import classes and packages for implementing the ReduceExample2 class

import java.util.*;

//create class ReduceExample3  
class ReduceExample3 {
    // main() method starts   
    public static void main(String[] args) {
        // Create a list of numbers either positve or negative  
        List<Integer> numbers = Arrays.asList(8, -4, 16, 0, 1, -6, 3);
        // calculate sum of all the elements of the numbers array using the reduce method   
        float sumOfElements = numbers.stream().reduce(0, (firstElement, secondElement) -> firstElement + secondElement);
        // show the result returned by the reduce method  
        System.out.println("The sum of all elements of numbers array " + sumOfElements);
    }
}  