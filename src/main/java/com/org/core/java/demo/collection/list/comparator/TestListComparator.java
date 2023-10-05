package com.org.core.java.demo.collection.list.comparator;

import com.org.core.java.demo.model.Recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestListComparator {
    public static void main(String args[]) {
        // Creating an empty ArrayList of Student type
        List<Recruitment> list = new ArrayList<>();

        // Adding entries in above List
        // using add() method
        list.add(new Recruitment("abc consultants","Rachel","Analyst",100000.0,true));
        list.add(new Recruitment("nyc consultants","Monica","DBA",90000.0,true));
        list.add(new Recruitment("abc consultants","Phoebe","Programmer",70000.0,true));
        list.add(new Recruitment("nj consultants","Jane","Programmer",80000.0,false));

        list.add(new Recruitment("xyz consultants","Ross","ProgramManager",200000.0,true));
        list.add(new Recruitment("chennai consultants","Chandler","ProjectManager",150000.0,true));
        list.add(new Recruitment("xyz consultants","Joe","Programmer",80000.0,true));
        list.add(new Recruitment("mumbai consultants","Any","Programmer",85000.0,false));

        // Display message on console for better readability
        System.out.println("Unsorted order of the details");

        // Iterating over entries to print them
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting the entries by company name
        Collections.sort(list, new GetDataByCompanyName());

        System.out.println("\nSorted by CompanyName");

        // We will get the sorted order now by company name
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting the entries by salary
        Collections.sort(list, new GetDataBySalary());

        System.out.println("\nSorted by salary");

        // We will get the sorted order now by salary
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting the entries by designation
        Collections.sort(list, new GetDataByDesignation());

        System.out.println("\nSorted by designation");

        // We will get the sorted order now by designation
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting the entries by designation and salary
        Collections.sort(list, new GetDataByDesignationAndSalary());

        System.out.println("\nSorted by designation and salary");

        // We will get the sorted order now by salary
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

}
