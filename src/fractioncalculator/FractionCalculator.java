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
        System.out.println("+------------------------------------+");
        while(!done) {
            String input = getInput();
            Parser.parse(input);
        }
    }
    
    public static String getInput() {
        return getInputTestCase();
    }

    private static String getInputFromConsole() {
        return null;
    }

    private static String getInputTestCase() {
        counter = counter > testCases.length ? 0 : counter+1;
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
            "2_7/6"
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
