import java.math.BigInteger;

public class Exercise057 {

    public static void main(String[] args) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        BigInteger swap = BigInteger.ZERO;

        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            numerator = numerator.add(denominator);
            swap = numerator;
            numerator = denominator;
            denominator = swap;
            numerator = numerator.add(denominator);

            if (numerator.toString().length() > denominator.toString().length()) {
                count++;
            }
        }
        System.out.println(count);
    }

}