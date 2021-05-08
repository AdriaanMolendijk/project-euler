public class Exercise035 {

    private static boolean[] sieve;

    public static void main(String[] args) {
        int limit = 1_000_000;
        sieve = primeSieve(limit);
        int count = 0;
        for (int n = 2; n < limit; n++)
        {
            if (IsCircPrime(n)) count++;
        }
        System.out.println(count);
    }

    public static boolean IsCircPrime(int n)
    {
        String num = Integer.toString(n);
        String circ;
        for (int i = 0; i < num.length(); i++)
        {
            circ = num.substring(i) + num.substring(0, i);
            if (!sieve[Integer.parseInt(circ) - 1]) return false;
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
