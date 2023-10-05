package com.org.core.java.demo.clone.deep;

public class UsesEx {

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        Ex e = new Ex(vals);
        e.showData(); // prints out [3, 7, 9]
        vals[0] = 13;
        e.showData(); // prints out [3, 7, 9]

        // changes in array values will not be
        // shown in data values.
    }
}
