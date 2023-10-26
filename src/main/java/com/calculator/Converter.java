package com.calculator;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static void convertRomanToArabic(String[] expression) {
        expression[0] = romanToArabic(expression[0]);
        expression[2] = romanToArabic(expression[2]);
    }// convertRomanToArabic

    public static String convertArabicToRoman(int value) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (value >= values[i]) {
                result.append(romanNumerals[i]);
                value -= values[i];
            }
        }

        return result.toString();
    }// public static String convertArabicToRoman(int value)

    public static String romanToArabic(String romanNumber) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        int result = 0;
        int prevValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char ch = romanNumber.charAt(i);
            int value = romanValues.get(ch);
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return Integer.toString(result);
    }// private static String romanToArabic(String romanNumber)
}// public class Converter
