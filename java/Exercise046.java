import java.util.ArrayList;

public class Exercise046 {

    private static ArrayList<Integer> primes = new ArrayList();
    private static ArrayList<Integer> squares = new ArrayList();
    private static ArrayList<Integer> goldbachs = new ArrayList();

    public static void main(String[] args) {
        int limit = 10_000;
        boolean[] sieve = primeSieve(limit);
        squares.add(1);
        for (int n = 2; n <= limit; n++) {
            if (sieve[n - 1]) primes.add(n);
            squares.add(n * n);
            if (n % 2 == 1 && !sieve[n - 1]) {
                goldbachs.add(n);
            }
        }

        for (int p : primes) {
            for (int s : squares) {
                int number = p + 2 * s;
                if (number > limit) break;
                if (goldbachs.contains(Integer.valueOf(number)))
                    goldbachs.remove(Integer.valueOf(number));
            }
        }
        System.out.println(goldbachs.get(0));
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
