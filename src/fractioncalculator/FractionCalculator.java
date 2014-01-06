/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: FractionCalculator (1/4)
 */

package fractioncalculator;

import java.util.Scanner;

public class FractionCalculator {
    
    private static int counter;
    private static String[] testCases;
    private static Scanner input;
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        populateTestCases();
        boolean done = false;
        
        System.out.println("+------------------------------------+");
        System.out.println("| Welcome to the Fraction Calculator |");
        System.out.println("| Enter an expression or \"q\" to quit |");
        System.out.println("| \"a_b/c\" represents mixed fractions |");
        System.out.println("| \"a\" - whole part : \"b\" - numerator |");
        System.out.println("| \"c\" is denominator of the fraction |");
        System.out.println("| +, -, *, and / are valid operators |");
        System.out.println("| Whitespace will all be disregarded |");
        System.out.println("| Any other character is disregarded |");
        System.out.println("| Order of operations is needed here |");
        System.out.println("| Version 1.0, made by Shreyas Raman |");
        System.out.println("+------------------------------------+");
        
        while (!done) {
            String inputString = getInput();
            if (inputString.equals("q")) {
                done = true;
            } else {
                System.out.println(Parser.parse(inputString));
            }
            /*
            IntFraction f1 = new IntFraction((int) (10*Math.random()+1),(int) (10*Math.random()+1));
            IntFraction f2 = new IntFraction((int) (10*Math.random()+1),(int) (10*Math.random()+1));
            System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
            System.out.println(f1 + " - " + f2 + " = " + f1.subt(f2));
            System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
            System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
            */
        }
    }
    
    public static String getInput() {
        return getConsole();
    }

    private static String getConsole() {
        return input.nextLine();
    }

    private static String getTestCase() {
        counter = counter<testCases.length-1?counter+1:0;
        return testCases[counter];
    }

    private static void populateTestCases() {
        testCases = new String[] {
            "1/3", 
            "1 * 2",
            "1*2",
            "1+2+6",
            "1-6",
            "7/6",
            "2_3/4+1",
            "2_7/6",
            "5_16/5",
            "(17/2)/(15/2)",
            "1/1",
            "1//1",
            "9.1/9",
            "asdf",
            "09",
            "0/0",
            "1/0",
            "0/1",
            "1/2+3",
            "1+2/3",
            "1/2/3",
            "1-2",
            "1/2 / -1/4",
            "1/-6",
            "99/99/99",
            "0"
        };
    }
}

/*
 * 1/2/3   = 1/6
 *  1/2/3  = 1/6
 * 1 /2/3  = 3/2
 * 1/ 2/3  = error
 * 1/2 /3  = 1/6
 * 1/2/ 3  = 1/6
 */
