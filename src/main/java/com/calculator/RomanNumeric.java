package com.calculator;

public enum RomanNumeric {
    I (1),
    IV (4),
    V (5),
    IX (9),
    X (10),
    XL (40),
    L (50),
    XC (90),
    C (100),
    CD (400),
    D (500),
    CM (900),
    M (1000);


    private final int arabicInteger;
    private RomanNumeric (int arabicInteger) {
        this.arabicInteger = arabicInteger;
    }

    public int getArabicInteger() {
        return arabicInteger;
    }
}
