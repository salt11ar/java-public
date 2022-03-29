import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.math.BigDecimal;
/**
 * Multiple solutions for fibonacci calculation 
 * applicable to finances as well 
 * 
 */

public class Fibonacci {
    

    /** Using exact integer arithmetic, print N_Terms ascending
    members of the Fibonacci sequence, prefixed by their term numbers,
    and followed by the ratio of successive terms, to demonstrate the
    1.618...^n growth (the ratio approaches the golden ratio, (1 +
    sqrt(5))/2 = 1.6180339887498949, and reaches it (to 64-bit machine
    precision) at 41 terms: the fourth item on each line is the
    difference from the golden ratio).

    Java's BigDecimal package, which is intended for simple
    high-precision currency calculations, does not provide elementary
    functions, such as sqrt(), so we supply a 100D-string
    representation for the golden_ratio. */

    private static final int Fractional_Digits = 50; //
    private static final int N_Terms = 200; //

    static final BigDecimal golden_ratio = new BigDecimal("1.618033988749894848204586834365638117720309179805762862135448622705260462818902449707207204189391138");


    /** Print ascending members of the Fibonacci sequence that are
    representable as 64-bit signed integers, prefixed by their term
    numbers, and followed by the ratio of successive terms, to
    demonstrate the 1.618...^n growth (the ratio approaches the golden
    ratio, (1 + sqrt(5))/2 = 1.6180339887498949, and reaches it (to
    machine precision) at 41 terms: the fourth item on each line is
    the difference from the golden ratio).

    This program also shows the hoops that one must jump through in
    Java to get right-adjusted fixed-width output fields, a feature
    that is utterly trivial in C, C++, Pascal, and Fortran. The comma
    separators in the Java output are, however, a nice touch. :^) */
    static final double golden_ratio1 = (1.0 + Math.sqrt(5.0))/2.0;


    public static void main( String[] args)
    {
        int nResult = solutionBasic(0); 
        System.out.println("Result: " +nResult );

        nResult = solutionBasic(1); 
        System.out.println("Result: " +nResult );

        nResult = solutionBasic(4); 
        System.out.println("Result: " +nResult );
        
        nResult = solutionBasic(10); 
        System.out.println("Result: " +nResult );



        solution1();
        
        solution2();

    }

    private static void solution2() {
        BigInteger lo = BigInteger.valueOf(1L);
        BigInteger hi = BigInteger.valueOf(1L);
        int n = 1;

        System.out.print(n);
        System.out.print("\t");
        System.out.println(lo);

        while (n < N_Terms)
        {
            n++;
            System.out.print(n);
            System.out.print("\t");
            System.out.print(hi);
            System.out.print("\t");
            BigDecimal ratio = new BigDecimal(hi);
            BigDecimal den = new BigDecimal(lo);
            ratio = ratio.divide(den, Fractional_Digits, ratio.ROUND_HALF_DOWN);
            System.out.print(ratio);
            System.out.print("\t");
            System.out.println(ratio.subtract(golden_ratio).setScale(Fractional_Digits,
                                        ratio.ROUND_HALF_DOWN));
            hi = lo.add(hi);
            lo = hi.subtract(lo);
        }
    }    

    private static String pad(String s, int pad_len)
    {
	if (s.length() >= pad_len)
	    return (s);
	else
	{
	    int nblanks = pad_len - s.length();
	    StringBuffer blanks = new StringBuffer(nblanks);

	    blanks.setLength(nblanks);
	    for (int k = 0; k < blanks.length(); ++k)
		blanks.setCharAt(k,' ');
	    return (blanks + s);
	}
    }

    private static void solution1()
    {
        long lo = 1L;
        long hi = 1L;
        long n = 1L;
        double ratio;
        DecimalFormat myFormat = (DecimalFormat)NumberFormat.getInstance();

        myFormat.setGroupingSize(3);
        myFormat.setMinimumIntegerDigits(1);
        myFormat.setMaximumIntegerDigits(2);
        myFormat.setMinimumFractionDigits(0);
        myFormat.setMaximumFractionDigits(0);
        System.out.print(myFormat.format(n));

        System.out.print("\t");

        myFormat.setMinimumIntegerDigits(1);
        myFormat.setMaximumIntegerDigits(19);
        System.out.println(pad(myFormat.format(lo),25));

        while (hi > 0L)
        {
            n++;

            myFormat.setMinimumIntegerDigits(1);
            myFormat.setMaximumIntegerDigits(2);
            myFormat.setMinimumFractionDigits(0);
            myFormat.setMaximumFractionDigits(0);
            System.out.print(myFormat.format(n));

            System.out.print("\t");

            myFormat.setMinimumIntegerDigits(1);
            myFormat.setMaximumIntegerDigits(19);

            System.out.print(pad(myFormat.format(lo),25));


            System.out.print("\t");

            myFormat.setMinimumIntegerDigits(1);
            myFormat.setMaximumIntegerDigits(19);

            System.out.print(pad(myFormat.format(hi),25));

            System.out.print("\t");

            ratio = (double)hi/(double)lo;

            myFormat.setMinimumIntegerDigits(1);
            myFormat.setMaximumIntegerDigits(1);
            myFormat.setMinimumFractionDigits(16);
            myFormat.setMaximumFractionDigits(16);
            System.out.print(myFormat.format(ratio));

            System.out.print("\t");

            myFormat.setMinimumIntegerDigits(1);
            myFormat.setMaximumIntegerDigits(1);
            myFormat.setMinimumFractionDigits(16);
            myFormat.setMaximumFractionDigits(16);
            System.out.println(pad(myFormat.format(ratio - golden_ratio1),19));

            hi = lo + hi;
            lo = hi - lo;
        }
    }


    private static int solutionBasic(int n ) {
        return fibo(n);
    }

    private static int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
    



}
