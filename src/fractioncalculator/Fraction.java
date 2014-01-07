/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: Fraction Interface (4/4)
 */

package fractioncalculator;

public interface Fraction {
    public Fraction add(Fraction other);
    public Fraction subt(Fraction other);
    public Fraction mult(Fraction other);
    public Fraction div(Fraction other);
    public int getN();
    public int getD();
    public String toString();
}
