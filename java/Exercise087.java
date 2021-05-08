import java.util.ArrayList;
import java.util.HashSet;

public class Exercise087 {

    public static void main(String[] args) {
        int limit = 50_000_000;
        boolean[] sieve = primeSieve(limit);

        ArrayList<Long> primes = new ArrayList<Long>();
        ArrayList<Long> primes2 = new ArrayList<Long>();
        ArrayList<Long> primes3 = new ArrayList<Long>();
        ArrayList<Long> primes4 = new ArrayList<Long>();

        for (int p = 2; p <= Math.sqrt(limit); p++)
        {
            if (sieve[p - 1]) primes.add((long)p);
        }

        long p2, p3, p4;
        for (long p : primes)
        {
            p2 = p * p;
            p3 = p2 * p;
            p4 = p3 * p;
            primes2.add(p2);
            primes3.add(p3);
            primes4.add(p4);
        }

        HashSet<Long> numbers = new HashSet<>();
        for (long prime2 : primes2)
        {
            for (long prime3 : primes3)
            {
                for (long prime4 : primes4)
                {
                    long sum = prime2 + prime3 + prime4;
                    if (sum > limit) break;
                    numbers.add(sum);
                }
            }
        }
        System.out.println(numbers.size());
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
