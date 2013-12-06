/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: Fraction Interface (4/4)
 */

package fractioncalculator;

public interface Fraction {
    public IntFraction add(IntFraction other);
    public IntFraction subtract(IntFraction other);
    public IntFraction multiply(IntFraction other);
    public IntFraction divide(IntFraction other);
    public IntFraction simplify(IntFraction fraction);
    public int getNumerator();
    public int getDenominator();
    public String toString();
}
