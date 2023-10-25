package com.calculator;

import java.util.List;

public class Validator {
    public static boolean checkingRomanOrArabic(String[] expression) throws NumberFormatException {
        boolean isRomanFirst = Validator.checkIsRoman(expression[0]);
        boolean isRomanSecond = Validator.checkIsRoman(expression[2]);

        if ((isRomanFirst && !isRomanSecond) || (!isRomanFirst && isRomanSecond)) {
            throw new NumberFormatException("Используются одновременно разные системы счисления!");
        }

        return isRomanFirst && isRomanSecond;
    }// public static void checkingRomanOrArabic(String[] expression) throws IOException

    public static void checkingNumbersArguments(String[] expression) throws IllegalArgumentException {
        if (expression.length < 3) {
            throw new IllegalArgumentException("Строка не является математической операцией");
        } else if (expression.length > 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию");
        }
    }// validateNumbersArguments

    public static void checkingForInteger(String[] expression) throws IllegalArgumentException {
        try {
            int argumentFirst = Integer.parseInt(expression[0]);
            int argumentLast = Integer.parseInt(expression[2]);
            if ((argumentFirst < 1 || argumentFirst > 10) || (argumentLast < 1 || argumentLast > 10)) {
                throw new IllegalArgumentException("Аргументы вне допустимом диапозоне");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Агрументы должны быть числами");
        }
    }// public static void checkingInteger(String[] expression) throws IOException
    private static boolean checkIsRoman(String argument) {
        List<Character> romanIntegers = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');

        for(char c : argument.toCharArray()) {
            if (!romanIntegers.contains(c)) {
                return false;
            }
        }// for each character in argument
        return true;
    }// private static boolean checkIsRoman

}// public class Validator
