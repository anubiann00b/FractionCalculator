/* Shreyas Raman
 * APCS Period 2
 * January 10, 2014
 * Project 2: Parser (3/4)
 */

package fractioncalculator;

public class Parser {

    public static Fraction parse(String input) {
        return parseFraction(clean(input));
    }
    
    public static Fraction parseFraction(String input) {
        for (int i=0;i<input.length();i++) {
            if (input.charAt(i)=='*') {
                return IntFraction.mult(parseFraction(input.substring(0,i)),
                        parseFraction(input.substring(i+1,input.length())));
            } else if(input.charAt(i)=='+')
                return IntFraction.add(parseFraction(input.substring(0,i)), 
                        parseFraction(input.substring(i+1,input.length())));
        }
        return new IntFraction(input);
    }
    
    public static String clean(String s) {
        String ns = "";
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c>=47&&c<=57 || c==45 || c==43 || c==42 || c==95) {
                ns += c;
            }
        }
        return ns;
    }
    
    public static boolean isOperator(char input) {
        return input == '+' || input == '-' || input == '*' || input == '/';
    }
}
