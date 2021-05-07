import java.util.ArrayList;

public class Exercise060 {

    private static ArrayList<Integer> primes = new ArrayList();
    private static boolean[] sieve;

    public static void main(String[] args) {
        int limit = 10_000;
        sieve = primeSieve(limit * limit);
        for (int n = 2; n <= limit; n++)
        {
            if (sieve[n - 1]) primes.add(n);
        }

        int length = primes.size();
        int p1, p2, p3, p4, p5;
        for (int i1 = 0; i1 < length; i1++)
        {
            p1 = (int) primes.get(i1);
            for (int i2 = i1 + 1; i2 < length; i2++)
            {
                p2 = (int) primes.get(i2);
                if (isConcatPrime(p1, p2))
                {
                    for (int i3 = i2 + 1; i3 < length; i3++)
                    {
                        p3 = (int) primes.get(i3);
                        if (isConcatPrime(p1, p3) && isConcatPrime(p2, p3))
                        {
                            for (int i4 = i3 + 1; i4 < length; i4++)
                            {
                                p4 = (int) primes.get(i4);
                                if (isConcatPrime(p1, p4) && isConcatPrime(p2, p4) && isConcatPrime(p3, p4))
                                {
                                    for (int i5 = i4 + 1; i5 < length; i5++)
                                    {
                                        p5 = (int) primes.get(i5);
                                        if (isConcatPrime(p1, p5) && isConcatPrime(p2, p5) &&
                                                isConcatPrime(p3, p5) && isConcatPrime(p4, p5))
                                        {
                                            int sum = p1 + p2 + p3 + p4 + p5;
                                            System.out.println(sum);
                                            System.exit(0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean isConcatPrime(int p1, int p2)
    {
        int concat1 = Integer.parseInt(Integer.toString(p1) + Integer.toString(p2));
        if (!sieve[concat1 - 1]) return false;
        int concat2 = Integer.parseInt(Integer.toString(p2) + Integer.toString(p1));
        if (!sieve[concat2 - 1]) return false;
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
