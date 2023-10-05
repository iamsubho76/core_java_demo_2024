package com.org.core.java.demo.clone.shallow;

import java.util.Arrays;

//code illustrating shallow copy
public class Ex {

    private final int[] data;

    // makes a shallow copy of values
    public Ex(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
