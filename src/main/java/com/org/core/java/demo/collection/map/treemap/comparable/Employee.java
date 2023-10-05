package com.org.core.java.demo.collection.map.treemap.comparable;// Creating TreeMap objects using
// Comparable interface in Java

// Importing all generic java utility and input

import java.io.*;
import java.util.*;

// User-defined class named Employee
// implementing comparable
public class Employee implements Comparable<Employee> {

    // Attributes of object of class
    int id;
    String name;

    // Parameterized constructor for user-defined class
    public Employee(int id, String name) {
        // This keyword refers to
        // current object in a constructor
        this.id = id;
        this.name = name;
    }

    // Comparable interface
    public int compareTo(Employee e) {
        // Two instance of class can be compared
//        int diff = this.id - e.id;
        int diff = this.name.compareTo(e.name);

        // Note: Two equal employee Id will return 0
        return diff;
    }
}

// Main class
class GFG {

    // Main driver method
    public static void main(String[] args) {
        // Declaring and initializing a TreeMap
        TreeMap<Employee, String> tm = new TreeMap<>();

        // Employee object1 (custom input)
        Employee e1 = new Employee(1, "Pathak");

        // Employee object2 (custom input)
        Employee e2 = new Employee(2, "Anshu");

        // Put method associating specific key-value in Map
        tm.put(e1, "First");
        tm.put(e2, "Second");

        // Iterating over Map using for-each loop
        // Map with employee key
        for (Map.Entry<Employee, String> e :
                tm.entrySet()) {

            // Print key-value pairs of TreeMap
            System.out.println(e.getKey().id + " "
                    + e.getKey().name + " "
                    + e.getValue());
        }
    }
}
