package com.org.core.java.demo.stream.reduce;//import classes and packages for implementing the ReduceExample1 class

import java.util.*;

//create class ReduceExample1    
class ReduceExample1 {
    // main() method starts  
    public static void main(String[] args) {
        // create a list of names to perform operations   
        List<String> javaTpointStudents = Arrays.asList("Emma Watson", "Paul Walker", "Leesa",
                "James", "Lilly");
        // The reduce() method takes the lambda expression that take two string type values
        // and returns a longer string
        //The Optional data is returned as a result from the reduce() method because the
        // list can be emplty on which reduce() method is called.
        Optional<String> newString = javaTpointStudents
                .stream()
                .reduce((firstName, secondName) ->
                        firstName.length() > secondName.length() ? firstName : secondName);
        // show the result returned by the reduce method  
        newString.ifPresent(System.out::println);
    }
}  