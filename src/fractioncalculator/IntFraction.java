/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: IntFraction (2/4)
 */

package fractioncalculator;

public class IntFraction implements Fraction {
    
    private int n;
    private int d;
    
    public IntFraction() {
        this(true,0,0,0);
    }
    
    public IntFraction(int n, int d) {
        this(true,0,n,d);
    }
    
    public IntFraction(boolean sign, int n, int d) {
        this(sign,0,n,d);
    }
    
    public IntFraction(boolean sign, int num, int n, int d) {
        this.n = (sign?1:-1)*n+num*d;
        this.d = d;
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
        f.n = f1.n*f2.d + f2.n*f1.d;
        f.d = f1.d*f2.d;
        return simplify(f);
    }
    
    public static IntFraction subtract(IntFraction f1, IntFraction f2) {
        return add(f1,switchSign(f2));
    }

    public static IntFraction multiply(IntFraction f1, IntFraction f2) {
        IntFraction f = new IntFraction();
        f.n = f1.n*f2.n;
        f.d = f1.d*f2.d;
        return simplify(f);
    }

    public static IntFraction divide(IntFraction f1, IntFraction f2) {
        return multiply(f1,inverse(f2));
    }
    
    public static IntFraction simplify(IntFraction f) {
        int gcd = gcd(f.n,f.d);
        if(gcd != 0) { // Otherwise unsimplifiable.
            f.n = f.n/gcd;
            f.d = f.d/gcd;
        }
        return f;
    }

    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }
    
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0)
            return a+b;
        return gcd(b,a%b);
    }
    
    public String toString() {
        return n + "/" + d;
    }

    private static IntFraction switchSign(IntFraction f) {
        IntFraction frac = new IntFraction(-f.n,f.d);
        return frac;
    }
    private static IntFraction inverse(IntFraction f) {
        IntFraction frac = new IntFraction(f.d,f.n);
        return frac;
    }
}
