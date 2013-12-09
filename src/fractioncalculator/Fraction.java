/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: Fraction Interface (4/4)
 */

package fractioncalculator;

public interface Fraction {
    public IntFraction add(IntFraction other);
    public IntFraction subt(IntFraction other);
    public IntFraction mult(IntFraction other);
    public IntFraction div(IntFraction other);
    public int getN();
    public int getD();
    public String toString();
}
