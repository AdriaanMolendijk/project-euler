public class Exercise037 {

    private static boolean[] sieve;

    public static void main(String[] args) {
        int limit = 1_000_000;
        sieve = primeSieve(limit);

        int sum = 0;
        for (int n = 10; n <= limit; n++)
            if (isTruncPrime(n)) sum += n;
        System.out.println(sum);
    }

    public static boolean isTruncPrime(int n)
    {
        if (!sieve[n - 1]) return false;
        String num = Integer.toString(n);
        String left, right;
        int length = num.length();
        for (int i = 1; i < length; i++)
        {
            left = num.substring(0, i);
            right = num.substring(i);
            if (!sieve[Integer.parseInt(left) - 1] || !sieve[Integer.parseInt(right) - 1])
                return false;
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
