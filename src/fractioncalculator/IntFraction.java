/* Shreyas Raman
 * APCS Period 2
 * December 3, 2013
 * Project 2: IntFraction (2/4)
 */

package fractioncalculator;

public class IntFraction implements Fraction {
    
    private int n;
    private int d;
    private boolean negative;
    
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
            if (input.charAt(0) == '-') {
                negative = true;
            }
            d = Integer.parseInt(input.substring(input.indexOf('/')+1,input.length()));
            if (d<0) {
                negative = negative?false:true;
                d = -d;
            }
            int wholePart = Math.abs(Integer.parseInt(input.substring(0,input.indexOf('_'))));
            n = wholePart*d
                    + Math.abs(Integer.parseInt(input.substring(input.indexOf('_')+1,input.indexOf('/'))));
            n*=wholePart<0?-1:1;
        } else if(!input.contains("_") && input.contains("/")) {
            n = Integer.parseInt(input.substring(0,input.indexOf('/')));
            d = Integer.parseInt(input.substring(input.indexOf('/')+1,input.length()));
        }
        simp(this);
    }
    
    public Fraction add(Fraction other) {
        return add(this, other);
    }

    public Fraction subt(Fraction other) {
        return subt(this, other);
    }

    public Fraction mult(Fraction other) {
        return mult(this, other);
    }

    public Fraction div(Fraction other) {
        return div(this, other);
    }
    
    public static IntFraction add(Fraction f1, Fraction f2) {
        IntFraction f = new IntFraction();
        f.n = f1.getN()*f2.getD() + f2.getN()*f1.getD();
        f.d = f1.getD()*f2.getD();
        return simp(f);
    }
    
    public static IntFraction subt(Fraction f1, Fraction f2) {
        return add(f1,switchSign(f2));
    }

    public static IntFraction mult(Fraction f1, Fraction f2) {
        IntFraction f = new IntFraction();
        f.n = f1.getN()*f2.getN();
        f.d = f1.getD()*f2.getD();
        return simp(f);
    }

    public static IntFraction div(Fraction f1, Fraction f2) {
        return mult(f1,inverse(f2));
    }
    
    public static IntFraction simp(IntFraction f) {
        if (f.d<0) {
            f.negative = f.negative?false:true;
            f.d = -f.d;
        }
        if (f.n<0) {
            f.negative = f.negative?false:true;
            f.n = -f.n;
        }
        int gcd = gcd(f.n,f.d);
        if(gcd != 0) { // Otherwise unsimplifiable.
            f.n = f.n/gcd;
            f.d = f.d/gcd;
        }
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
        
        if (f.d == 0)
            return "Error: Denominator is zero.";
        else if (f.n == 0)
            return "0";
        else if (f.d == 1)
            return String.valueOf((negative?"-":"") + f.n);
        else if (f.n < f.d)
            return (negative?"-":"") + f.n + "/" + f.d;
        else
            return (negative?"-":"") + f.n/f.d + "_" + f.n%f.d + "/" + f.d;
    }
    
    private static IntFraction switchSign(Fraction f) {
        IntFraction frac = new IntFraction(-f.getN(),f.getD());
        return frac;
    }
    private static IntFraction inverse(Fraction f) {
        IntFraction frac = new IntFraction(f.getD(),f.getN());
        return frac;
    }
}
