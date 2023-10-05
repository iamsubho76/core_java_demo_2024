package com.org.core.java.demo.stream.reduce;
//import classes and packages for implementing the ReduceExample2 class

import java.util.*;

//create class ReduceExample2
public class ReduceExample2 {
    // main() method starts
    public static void main(String[] args) {
        // create a array of monuments to perform operations
        String[] monuments = {"Taj Mahal", "Qutab Minar", "Konark Sun Temple", "India Gate", "Charminar"};
        // The reduce() method takes the lambda expression that take two string type values and returns a longer string
        //The Optional data is returned as a result from the reduce() method because the list can be emplty on which reduce() method is called.

        Optional<String> newCombineMonument = Arrays.stream(monuments).reduce((firstMonument, secondMonument) -> firstMonument + "-" + secondMonument);

        // show the result returned by the reduce method
        if (newCombineMonument.isPresent()) {
            System.out.println(newCombineMonument.get());
        }
    }
}
