package com.org.core.java.demo.other;

import java.util.Collections;
import java.util.List;

public final class ImmutableEmployeeWIthUnmodifiablListExample {
    private final String name;
    private final int age;
    private final List<Address> addresses;

    public ImmutableEmployeeWIthUnmodifiablListExample(String name, int age, List<Address> addresses) {
        this.name = name;
        this.age = age;
        // Create a defensive copy of the addresses list to ensure immutability
        this.addresses = Collections.unmodifiableList(addresses);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Address> getAddresses() {
        // Return an unmodifiable view of the addresses list to prevent modifications
        return addresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}

class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        // Create a list of addresses for an employee
        List<Address> addresses = List.of(
                new Address("123 Main St", "City1", "12345"),
                new Address("456 Elm St", "City2", "67890")
        );

        // Create an employee object
        ImmutableEmployeeWIthUnmodifiablListExample employee = new ImmutableEmployeeWIthUnmodifiablListExample("John Doe", 30, addresses);

        // Print employee details
        System.out.println("First :: " + employee);
        // If you try to execute by adding new address you will get below error
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1067)
        //	at com.org.core.java.demo.other.Main.main(ImmutableEmployeeWIthUnmodifiablListExample.java:93)
        List<Address> addresses1 = employee.getAddresses();
        Address city2 = new Address("457 new st", "City2", "67890");
        addresses1.add(city2);
        System.out.println("After alter :: " + employee);

    }
}
