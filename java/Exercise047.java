import java.util.ArrayList;
import java.util.HashSet;

public class Exercise047 {

    public static void main(String[] args) {
        int numFactors = 4;
        for (int i = 1; i <= 1_000_000; i++)
        {
            boolean found = true;
            for (int j = 1; j <= numFactors; j++)
            {
                if (!hasKPrimeFactors(i + j - 1, numFactors))
                {
                    found = false;
                    break;
                }
            }
            if (found)
            {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    public static boolean hasKPrimeFactors(int n, int k)
    {
        ArrayList<Long> factors = primeFactorization(n);
        HashSet<Integer> primes = new HashSet<>();
        for (long factor : factors)
        primes.add((int)factor);
        return primes.size() == k;
    }

    /**
     * This method returns the prime factorization of a number.
     * @param n the number to be factorized
     * @return an ArrayList representing the prime factorization.
     */
    public static ArrayList<Long> primeFactorization(long n)
    {
        ArrayList<Long> primeFactorization = new ArrayList<Long>();
        long div = 1;
        while (n != 1)
        {
            div++;

            // if div divides l
            if (n % div == 0)
            {
                primeFactorization.add(div);
                n /= div;
                div--;
                continue;
            }

            if (div > Math.sqrt(n))
            {
                primeFactorization.add(n);
                break;
            }
        }

        return primeFactorization;
    }
}
