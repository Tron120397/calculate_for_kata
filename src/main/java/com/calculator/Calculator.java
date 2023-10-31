package com.calculator;

public class Calculator {
    private String[] expression;
    Validator validator;

    public Calculator(String[] expression) throws IllegalArgumentException, IndexOutOfBoundsException {
        this.validator = new Validator(expression);
        this.expression = validator.getExpression();

    }// constructor Calculator and checking expression with Validator

    public void setExpression(String[] expression) {
        validator.setExpression(expression);
        this.expression = expression;
    }// setter for expression

    public String calculate() throws ArithmeticException, NumberFormatException {
        int first = Integer.parseInt(this.expression[0]);
        int second = Integer.parseInt(this.expression[2]);


        int result = switch (this.expression[1]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new ArithmeticException("Не сущесвтующий операнд");
        };// main calculation

        if (validator.isRoman()) {
            if (result < 0) {
                throw new NumberFormatException("В риммской системе нет отрицательных чисел");
            }
            return Converter.convertArabicToRoman(result);
        }// roman numeral check

        return Integer.toString(result);
    }// public String calculate
}// public class Calculator
