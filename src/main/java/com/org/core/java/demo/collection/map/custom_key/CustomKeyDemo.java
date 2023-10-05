package com.org.core.java.demo.collection.map.custom_key;

import com.org.core.java.demo.model.Account;

import java.util.HashMap;
import java.util.Map;


// https://howtodoinjava.com/java/collections/hashmap/design-good-key-for-hashmap/#:~:text=We%20should%20Make%20the%20HashMap's%20Key%20Immutable,-For%20the%20above&text=So%20it%20actually%20solves%20almost,a%20good%20key%20object%20candidate.

public class CustomKeyDemo {

    public static void main(String[] args) {
        //Create a HashMap with mutable key
        Map<Account, String> map = new HashMap<>();
//Create key 1
        Account a1 = new Account(1);
        a1.setHolderName("A_ONE");
//Create key 2
        Account a2 = new Account(2);
        a2.setHolderName("A_TWO");
//Put mutable key and value in map
        map.put(a1, a1.getHolderName());
        map.put(a2, a2.getHolderName());
//Change the keys state so hash map should be calculated again
        a1.setHolderName("Defaulter");
        a2.setHolderName("Bankrupt");
//Success !! We are able to get back the values
        System.out.println(map.get(a1)); //Prints A_ONE
        System.out.println(map.get(a2)); //Prints A_TWO
//Try with newly created key with same account number
        Account a3 = new Account(1);
        a3.setHolderName("A_THREE");
//Success !! We are still able to get back the value for account number 1
        System.out.println(map.get(a3)); //Prints A_ONE

         map.put(a3, a3.getHolderName());
        System.out.println(map.get(a3)); //
        System.out.println(map.get(a1)); //
        System.out.println(map.size());
    }
}
