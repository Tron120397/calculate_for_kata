package com.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }// try
        catch (Exception exception) {
            System.out.println(exception.getCause() + "\n" + exception.getMessage());
        }// catch (Exception exception)
    }// main

    public static String calc(String input) throws IndexOutOfBoundsException, IllegalArgumentException, ArithmeticException {
        try {
            Calculator calculator = new Calculator(input.split(" "));
            return calculator.calculate();
        }// try
        catch (IndexOutOfBoundsException | IllegalArgumentException | ArithmeticException exception) {
            return exception.getMessage();
        }
        // catch (NumberFormatException | ArithmeticException e)
    }
}// public class Main
