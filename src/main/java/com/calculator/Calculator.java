package com.calculator;

public class Calculator {
    private String[] expression;
    private boolean isRoman;

    public Calculator(String[] expression) {
        setExpression(expression);
    }

    public void setExpression(String[] expression) {
        this.expression = checkingExpression(expression);
    }

    private boolean isRoman() {
        return isRoman;
    }

    private void setIsRoman(boolean isRoman) {
        this.isRoman = isRoman;
    }

    private String[] checkingExpression(String[] expression) throws IllegalArgumentException {
        Validator.checkingNumbersArguments(expression);

        if (Validator.checkingRomanOrArabic(expression)) {
            Converter.convertRomanToArabic(expression);
            setIsRoman(true);
        }// if (Validator.checkingRomanOrArabic(expression))
        else {
            setIsRoman(false);
        }// else

        Validator.checkingForInteger(expression);


        return expression;
    }// public void checkingExpression(String[] expression) throws IOException {}

    public String calculate() throws ArithmeticException, NumberFormatException {
        int first = Integer.parseInt(this.expression[0]);
        int second = Integer.parseInt(this.expression[2]);


        int result = switch (this.expression[1]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new ArithmeticException("Не сущесвтующий операнд");
        };

        if (isRoman()) {
            if (result < 0) {
                throw new NumberFormatException("В риммской системе нет отрицательных чисел");
            }
            return Converter.convertArabicToRoman(result);
        }// roman numeral check

        return Integer.toString(result);
    }// public String calculate
}// public class Calculator
