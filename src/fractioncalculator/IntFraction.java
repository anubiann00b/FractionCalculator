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
        simp(this);
    }
    
    public IntFraction(String input) {
        if(!input.contains("/")) {
                n = Integer.parseInt(input.substring(0, input.length()));
                d = 1;
        } else if(input.contains("_") && input.contains("/")) {
                d = Integer.parseInt(input.substring(input.indexOf('/')+1,input.length()));
                int wholePart = Integer.parseInt(input.substring(0,input.indexOf('_')));
                n = Math.abs(wholePart)*d
                        + Integer.parseInt(input.substring(input.indexOf('_')+1,input.indexOf('/')));
                n*=wholePart<0?-1:1;
        } else if(!input.contains("_") && input.contains("/")) {
                n = Integer.parseInt(input.substring(0,input.indexOf('/')));
                d = Integer.parseInt(input.substring(input.indexOf('/')+1,input.length()));
        }
        simp(this);
    }
    
    public IntFraction add(IntFraction other) {
        return add(this, other);
    }

    public IntFraction subt(IntFraction other) {
        return subt(this, other);
    }

    public IntFraction mult(IntFraction other) {
        return mult(this, other);
    }

    public IntFraction div(IntFraction other) {
        return div(this, other);
    }
    
    public static IntFraction add(IntFraction f1, IntFraction f2) {
        IntFraction f = new IntFraction();
        f.n = f1.n*f2.d + f2.n*f1.d;
        f.d = f1.d*f2.d;
        return simp(f);
    }
    
    public static IntFraction subt(IntFraction f1, IntFraction f2) {
        return add(f1,switchSign(f2));
    }

    public static IntFraction mult(IntFraction f1, IntFraction f2) {
        IntFraction f = new IntFraction();
        f.n = f1.n*f2.n;
        f.d = f1.d*f2.d;
        return simp(f);
    }

    public static IntFraction div(IntFraction f1, IntFraction f2) {
        return mult(f1,inverse(f2));
    }
    
    public static IntFraction simp(IntFraction f) {
        if (f.d<0) {
            f.n = -f.n;
            f.d = -f.d;
        }
        boolean negative = false;
        if (f.n<0) {
            negative = true;
            f.n = -f.n;
        }
        int gcd = gcd(f.n,f.d);
        if(gcd != 0) { // Otherwise unsimplifiable.
            f.n = f.n/gcd;
            f.d = f.d/gcd;
        }
        f.n *= negative?-1:1;
        return f;
    }

    public int getN() {
        return n;
    }

    public int getD() {
        return d;
    }
    
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0)
            return a+b;
        return gcd(b,a%b);
    }
    
    public String toString() {
        IntFraction f = simp(this);
        
        boolean negative = false;
        
        if (f.n < 0) {
            negative = true;
            f.n = -f.n;
        }
        
        if (f.d == 0)
            return "Error: Denominator is zero.";
        else if (f.n == 0)
            return "0";
        else if (f.d == 1)
            return String.valueOf((negative?-1:1)*f.n);
        else if (f.n < f.d)
            return (negative?-1:1)*f.n + "/" + f.d;
        else
            return (negative?-1:1)*f.n/f.d + "_" + f.n%f.d + "/" + f.d;
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
