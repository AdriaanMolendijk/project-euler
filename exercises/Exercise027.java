public class Exercise027 {

    public static void main(String[] args) {
        boolean[] sieve = primeSieve(10_000_000);
        int maximum = 0, function;
        for (int b = 1; b <= 1000; b++)
        {
            for (int a = -b; a <= 1000; a++)
            {
                function = 0;
                for (int n = 1; n <= 500; n++)
                {
                    function = n * n + a * n + b;
                    if (function <= 0 || !sieve[function - 1])
                    {
                        if (n > maximum)
                        {
                            maximum = n;
                            System.out.println(a * b);
                        }
                        break;
                    }
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
