/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: IntFraction (2/4)
 */

package fractioncalculator;

public class IntFraction implements Fraction {
    
    private boolean positive;
    private int wholePart;
    private int numerator;
    private int denominator;
    
    public IntFraction(boolean positive, int numerator, int denominator) {
        this(positive,0,numerator,denominator);
    }
    public IntFraction(boolean positive, int wholePart, int numerator, int denominator) {
        this.positive = positive;
        this.wholePart = 0;
        this.numerator = numerator+wholePart*denominator;
        this.denominator = denominator;
    }
    
    public IntFraction add(IntFraction other) {
        return null;
    }

    public IntFraction subtract(IntFraction other) {
        return this.add(other.switchSign());
    }

    public IntFraction multiply(IntFraction other) {
        return null;
    }

    public IntFraction divide(IntFraction other) {
        return null;
    }
    
    public IntFraction simplify() {
        return null;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    public int gcd(int a, int b) {
        while (a!=b) {
            int q = b;
            b = a%b;
            a = q;
        }
        return a;
    }
    
    public String toString() {
        return (positive?"":"-") + (wholePart==0?"":wholePart+"_") + numerator + "/" + denominator;
    }

    private IntFraction switchSign() {
        this.positive = !positive;
        return this;
    }
}
