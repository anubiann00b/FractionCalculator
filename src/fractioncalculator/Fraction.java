/* Shreyas Raman
 * Mr. Peterson
 * APCS Period 2
 * 6 December 2013
 */

package fractioncalculator;

public interface Fraction {
    public IntFraction add(IntFraction other);
    public IntFraction subtract(IntFraction other);
    public IntFraction multiply(IntFraction other);
    public IntFraction divide(IntFraction other);
    public int getNumerator();
    public int getDenominator();
    public String toString();
}
