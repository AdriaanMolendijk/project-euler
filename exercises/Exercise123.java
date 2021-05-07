import java.math.BigInteger;

public class Exercise123 {

    public static void main(String[] args) {
        int limit = 1_000_000;
        boolean[] sieve = primeSieve(limit);

        BigInteger rem = BigInteger.ZERO;
        BigInteger target = BigInteger.valueOf(10_000_000_000L);
        int n = 0;
        for (int p = 1; p <= limit; p++)
        {
            if (sieve[p - 1])
            {
                n++;

                // term1 = (p+1)^n
                BigInteger term1 = BigInteger.valueOf(p).add(BigInteger.ONE);
                term1 = term1.pow(n);

                // term2 = (p-1)^n
                BigInteger term2 = BigInteger.valueOf(p).subtract(BigInteger.ONE);
                term2 = term2.pow(n);

                // square = p^2
                BigInteger square = BigInteger.valueOf(p).multiply(BigInteger.valueOf(p));
                rem = term1.add(term2).mod(square);

                if (rem.compareTo(target) > 0)
                {
                    System.out.println(n);
                    System.exit(0);
                }
            }
        }
    }

    /**
     * This method returns the prime sieve of all numbers up to a certain limit;
     * @param limit the limit of the prime sieve.
     * @return a boolean[] representing the sieve up to limit.
     */
    public static boolean[] primeSieve(int limit)
    {
        if (limit <= 0) throw new IllegalArgumentException("Limit must be >= 1");

        // limit >= 1 here
        boolean[] sieve = new boolean[limit];
        for (int i = 2; i <= limit; i++) sieve[i-1] = true;

        for (int i = 2; i <= Math.sqrt(limit); i++)
        {
            if (sieve[i-1])
            {
                int j = i * i;
                while (j <= limit)
                {
                    sieve[j-1] = false;
                    j += i;
                }
            }
        }

        return sieve;
    }
}
