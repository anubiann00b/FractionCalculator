/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: IntFraction (2/4)
 */

package fractioncalculator;

public class IntFraction implements Fraction {
    
    private int numerator;
    private int denominator;
    
    public IntFraction() {
        this(true,0,0,0);
    }
    
    public IntFraction(int numerator, int denominator) {
        this(true,0,numerator,denominator);
    }
    
    public IntFraction(boolean positive, int numerator, int denominator) {
        this(positive,0,numerator,denominator);
    }
    
    public IntFraction(boolean positive, int wholePart, int numerator, int denominator) {
        this.numerator = (positive?1:-1)*numerator+wholePart*denominator;
        this.denominator = denominator;
        simplify(this);
    }
    
    public IntFraction add(IntFraction other) {
        return add(this, other);
    }

    public IntFraction subtract(IntFraction other) {
        return subtract(this, other);
    }

    public IntFraction multiply(IntFraction other) {
        return multiply(this, other);
    }

    public IntFraction divide(IntFraction other) {
        return divide(this, other);
    }
    
    public static IntFraction add(IntFraction f1, IntFraction f2) {
        IntFraction f = new IntFraction();
        f.numerator = f1.numerator*f2.numerator;
        f.denominator = f1.denominator*f2.denominator;
        return simplify(f);
    }
    
    public static IntFraction subtract(IntFraction f1, IntFraction f2) {
        return add(f1,f2.switchSign());
    }

    public static IntFraction multiply(IntFraction f1, IntFraction f2) {
        IntFraction f = new IntFraction();
        f.numerator = f1.numerator*f2.numerator;
        f.denominator = f1.denominator*f2.denominator;
        return simplify(f);
    }

    public static IntFraction divide(IntFraction f1, IntFraction f2) {
        return multiply(f1,f2.inverse());
    }
    
    public static IntFraction simplify(IntFraction fraction) {
        int gcd = gcd(fraction.numerator,fraction.denominator);
        if(gcd != 0) { // Otherwise unsimplifiable.
            fraction.numerator = fraction.numerator/gcd;
            fraction.denominator = fraction.denominator/gcd;
        }
        return fraction;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0)
            return a+b;
        return gcd(b,a%b);
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }

    private IntFraction switchSign() {
        this.numerator = -1*this.numerator;
        return this;
    }
    private IntFraction inverse() {
        int num = this.numerator;
        this.numerator = this.denominator;
        this.denominator = num;
        return this;
    }
}
