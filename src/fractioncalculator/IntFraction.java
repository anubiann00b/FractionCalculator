/* Shreyas Raman
 * Mr. Peterson
 * APCS Period 2
 * 6 December 2013
 */

package fractioncalculator;

public class IntFraction implements Fraction {
    
    private boolean positive;
    private int wholePart;
    private int numerator;
    private int denominator;
    
    public IntFraction(boolean positive, int numerator, int denominator) {
        this.positive = positive;
        this.wholePart = 0;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public IntFraction(boolean positive, int wholePart, int numerator, int denominator) {
        
    }
    
    public IntFraction add(IntFraction other) {
        throw new UnsupportedOperationException("Not done yet~");
    }

    public IntFraction subtract(IntFraction other) {
        throw new UnsupportedOperationException("Not done yet~");
    }

    public IntFraction multiply(IntFraction other) {
        throw new UnsupportedOperationException("Not done yet~");
    }

    public IntFraction divide(IntFraction other) {
        throw new UnsupportedOperationException("Not done yet~");
    }

    public int getNumerator() {
        throw new UnsupportedOperationException("Not done yet~");
    }

    public int getDenominator() {
        throw new UnsupportedOperationException("Not done yet~");
    }
}
