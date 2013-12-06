/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: FractionCalculator (1/4)
 */

package fractioncalculator;

public class FractionCalculator {
    
    private static int counter;
    private static String[] testCases;
    
    public static void main(String[] args) {
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
        
        for(int i=0;i<10;i++) {
            /*
            String input = getInput();
            if (input.equals("q")) {
                done = true;
            } else {
                Parser.parse(input);
            }
            */
            IntFraction f1 = new IntFraction((int) (10*Math.random()+1),(int) (10*Math.random()+1));
            IntFraction f2 = new IntFraction((int) (10*Math.random()+1),(int) (10*Math.random()+1));
            System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
            System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
            System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
            System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        }
    }
    
    public static String getInput() {
        return getInputTestCase();
        //return getInputFromConsole();
    }

    private static String getInputFromConsole() {
        return null;
    }

    private static String getInputTestCase() {
        counter = counter<testCases.length-1?counter+1:0;
        return testCases[counter];
    }

    private static void populateTestCases() {
        testCases = new String[]{
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
