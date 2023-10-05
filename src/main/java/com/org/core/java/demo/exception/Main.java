package com.org.core.java.demo.exception;

/**
 * Example 4: Catching base and child exception classes
 * class Main {
 * public static void main(String[] args) {
 * try {
 * int array[] = new int[10];
 * array[10] = 30 / 0;
 * } catch (Exception | ArithmeticException | ArrayIndexOutOfBoundsException e) {
 * System.out.println(e.getMessage());
 * }
 * }
 * }
 * Run Code
 * Output
 * <p>
 * Main.java:6: error: Alternatives in a multi-catch statement cannot be related by subclassing
 * In this example, ArithmeticException and ArrayIndexOutOfBoundsException are both subclasses of the Exception class. So, we get a compilation error.
 */
class Main {
    public static void main(String[] args) {
        try {
            int[] array = new int[10];
            array[10] = 30 / 0;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}