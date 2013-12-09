/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: Parser (3/4)
 */

package fractioncalculator;

public class Parser {

    public static void parse(String input) {
        input = clean(input);
        for(int i=0;i<input.length();i++) {
            
        }
    }
    
    public static String clean(String s) {
        String ns = "";
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c>=47&&c<=57 || c==45 || c==43 || c==42 || c==95) {
                ns += s.charAt(i);
            }
        }
        return ns;
    }
}
