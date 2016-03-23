package com.thefallenpaladin.main;

/**
 * Created by Matthew on 3/22/2016.
 * A simple calculator class intended for use in project ENA.
 */
public class Calculator {
    public double addition(double a, double b) {
        double answer = a + b;
        return answer;
    }
    public double multiplication(double a, double b) {
        double answer = (a*b);
        return answer;
    }
    public double subtraction(double a, double b) {
        double answer = a - b;
        return answer;
    }
    public double division(double a, double b) {
        double answer = (a/b);
        return answer;
    }
}
