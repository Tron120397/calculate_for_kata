package com.calculator;

public class Main {
    public static String calc(String input) {
        String result = "";
        try {
            Calculator calculator = new Calculator(input.split(" "));
            result = calculator.calculate();
            return result;
        }// try
        catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }// catch (NumberFormatException | ArithmeticException e)
        catch (Exception e) {
            System.out.println(e.fillInStackTrace() + "\n" + e.getMessage());
        }// catch (Exception e)

        return result;
    }
}// public class Main
