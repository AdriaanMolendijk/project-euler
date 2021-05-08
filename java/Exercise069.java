import java.util.ArrayList;
import java.util.HashSet;

public class Exercise069 {

    public static void main(String[] args)
    {
        long phi;
        double frac, maxFrac = 0;
        int maxN = 0;

        for (int n = 2; n <= 1_000_000; n++)
        {
            phi = phi(n);
            frac = n * 1.0 / phi;
            if (maxFrac < frac)
            {
                maxFrac = frac;
                maxN = n;
            }
        }
        System.out.println(maxN);
    }

    static long phi(int n)
    {
        ArrayList<Long> factors = primeFactorization(n);
        HashSet<Long> primes = new HashSet<>();
        for (long f : factors) primes.add(f);
        double phi = n;
        for (long p : primes)
        phi *= (1 - 1.0 / p);
        return (long) phi;
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
