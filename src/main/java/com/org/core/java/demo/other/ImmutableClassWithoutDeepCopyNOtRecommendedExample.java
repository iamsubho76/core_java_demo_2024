package com.org.core.java.demo.other;

import java.util.HashMap;

public final class ImmutableClassWithoutDeepCopyNOtRecommendedExample {

    // fields of the FinalClassExample class
    private final int id;

    private final String name;

    private final HashMap<String, String> testMap;


    public ImmutableClassWithoutDeepCopyNOtRecommendedExample(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Shallow Copy for Object initialization");
        this.id = i;
        this.name = n;
        this.testMap = hm;
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        ImmutableClassWithoutDeepCopyNOtRecommendedExample ce = new ImmutableClassWithoutDeepCopyNOtRecommendedExample(i, s, h1);

        // print the ce values
        System.out.println("ce id: " + ce.getId());
        System.out.println("ce name: " + ce.getName());
        System.out.println("ce testMap: " + ce.getTestMap());
        // change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");
        // print the values again
        System.out.println("ce id after local variable change: " + ce.getId());
        System.out.println("ce name after local variable change: " + ce.getName());
        System.out.println("ce testMap after local variable change: " + ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: " + ce.getTestMap());

    }

    // Getter function for mutable objects

    public int getId() {
        return id;
    }

    //Constructor method performing shallow copy

    public String getName() {
        return name;
    }

    // Test the immutable class

    public HashMap<String, String> getTestMap() {
        return testMap;
    }

}