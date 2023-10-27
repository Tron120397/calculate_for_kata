package com.calculator;

import java.util.Arrays;

public class Converter {
    private static final RomanNumeric[] romanNumerics = RomanNumeric.values();

    public static void convertRomanToArabic(String[] expression) {
        expression[0] = convertRomanToArabic(expression[0]);
        expression[2] = convertRomanToArabic(expression[2]);
    }// convertRomanToArabic

    public static String convertArabicToRoman(int value) {
        StringBuilder result = new StringBuilder();

        for (int i = romanNumerics.length - 1; i >= 0; i--) {
            while (value >= romanNumerics[i].getArabicInteger()) {
                result.append(romanNumerics[i]);
                value -= romanNumerics[i].getArabicInteger();
            }// while (value >= romanNumerics[i].getArabicInteger())
        }// for (int i = romanNumerics.length - 1; i >= 0; i--)

        return result.toString();
    }// public static String convertArabicToRoman(int value)

    public static String convertRomanToArabic(String romanNumber) {
        int result = 0;
        int prevValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            String stringRomanNum = Character.toString(romanNumber.charAt(i));
            int value = RomanNumeric.valueOf(stringRomanNum).getArabicInteger();

            if (value < prevValue) {
                result -= value;
            }
            else {
                result += value;
            }

            prevValue = value;
        }// for (int i = romanNumber.length() - 1; i >= -; i--)

        return Integer.toString(result);
    }// private static String romanToArabic(String romanNumber)
}// public class Converter
