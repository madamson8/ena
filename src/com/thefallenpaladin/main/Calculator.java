package com.thefallenpaladin.main;

import java.util.Scanner;
/**
 * Created by Matthew on 3/22/2016.
 * A simple calculator class intended for use in project ENA.
 */
public class Calculator {
    public void calculatorPerformed(String aCommand) {
        Scanner userInput = new Scanner(System.in);
        if(aCommand.equals("calculator")) {
            System.out.println("Please type calculator and then whatever calculation you want to peform. \n EX. calculator add");
        }

        if(aCommand.equals("calculator add")) {
            System.out.println("First number?: ");
            double f_num = userInput.nextDouble(); //Snake case used to add readability.
            System.out.println("Second number?: ");
            double s_num = userInput.nextDouble();
            double addAnswer = addition(f_num, s_num);
            System.out.println("The answer is: " + addAnswer);
        }

        else if(aCommand.equals("calculator times")) {
            System.out.println("First number?: ");
            double f_num = userInput.nextDouble();
            System.out.println("Second number?: ");
            double s_num = userInput.nextDouble();
            double multAnswer = multiplication(f_num, s_num);
            System.out.println("The answer is: " + multAnswer);
        }

        else if(aCommand.equals("calculator subtract")) {
            System.out.println("First number?: ");
            double f_num = userInput.nextDouble();
            System.out.println("Second number?: ");
            double s_num = userInput.nextDouble();
            double subAnswer = subtraction(f_num, s_num);
            System.out.println(subAnswer);
        }

        else if(aCommand.equals("calculator divide")) {
            System.out.println("First number?: ");
            double f_num = userInput.nextDouble();
            System.out.println("Second number?: ");
            double s_num = userInput.nextDouble();
            double divAnswer = division(f_num, s_num);
            System.out.println(divAnswer);
        }
    }
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
