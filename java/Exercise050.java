import java.util.ArrayList;

public class Exercise050 {

    private static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        int limit = 1_000_000;
        boolean[] sieve = primeSieve(limit);
        for (int n = 2; n <= limit; n++)
        {
            if (sieve[n - 1]) primes.add(n);
        }

        int length = primes.size(), maxLength = 0;
        int sum, maxPrime = 0;
        for (int i = 0; i < length; i++)
        {
            for (int j = i + 1; j < length; j++)
            {
                sum = sumSeq(primes, i, j);
                if (sum > limit) break;
                if (sieve[sum - 1])
                {
                    if (j - i > maxLength)
                    {
                        maxLength = j - i;
                        maxPrime = sum;
                    }
                }
            }
        }
        System.out.println(maxPrime);
    }

    public static int sumSeq(ArrayList<Integer> numbers, int l, int r)
    {
        if (l < 0 || r >= numbers.size() || l > r)
            throw new IllegalArgumentException("Incorrect input, we dont have 0 <= l <= r <= numbers.Count.");
        int sum = 0;
        for (int index = l; index <= r; index++)
            sum += numbers.get(index);
        return sum;
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
