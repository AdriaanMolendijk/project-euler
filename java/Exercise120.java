import java.math.BigInteger;

public class Exercise120 {

    public static void main(String[] args)
    {
        int rem, maxRem;
        long remSum = 0;
        BigInteger term1, term2, square;
        for (int a = 3; a <= 1000; a++)
        {
            maxRem = 0;
            for (int n = 1; n <= 2 * a; n++)
            {
                // term1 = (a+1)^n
                term1 = BigInteger.valueOf(a).add(BigInteger.ONE);
                term1 = term1.pow(n);

                // term2 = (a-1)^n
                term2 = BigInteger.valueOf(a).subtract(BigInteger.ONE);
                term2 = term2.pow(n);

                // square = a^2
                square = BigInteger.valueOf(a).multiply(BigInteger.valueOf(a));
                rem = term1.add(term2).mod(square).intValue();
                maxRem = Math.max(maxRem, rem);
            }
            remSum += maxRem;
        }
        System.out.println(remSum);
    }

}
