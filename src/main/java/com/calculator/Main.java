package com.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите ваше выражение: ");
            String input = scanner.nextLine();

            while (!input.equals("end")) {
                Calculator calculator = new Calculator(input.split(" "));
                System.out.println(calculator.calculate());

                System.out.print("Введите ваше выражение: ");
                input = scanner.nextLine();
            }
        }// try
        catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // catch (NumberFormatException | ArithmeticException e)
        catch (Exception e) {
            System.out.println(e.fillInStackTrace() + "\n" + e.getMessage());
        }
    }// public static void main(String[] args)
}// public class Main
