public class PrimeSieve {

    private static boolean[] sieve;

    public static void main(String[] args)
    {
        int limit = 100_000_000;
        sieve = primeSieve(2 * limit);
        long sum = 0;
        for (int i = 1; i <= limit; i++)
        {
            if (divPrime(i)) sum += i;
        }
        System.out.println(sum);
    }

    public static boolean divPrime(int n)
    {
        int num;
        for (int d = 1; d <= Math.sqrt(n); d++)
        {
            if (n % d == 0)
            {
                num = d + n / d;
                if (!sieve[num - 1])
                {
                    return false;
                }
            }
        }
        return true;
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
