import java.util.ArrayList;
import java.util.HashSet;

public class Exercise072 {

    public static void main(String[] args) {
        Fraction current;
        long count = 0;
        for (int d = 2; d <= 1_000_000; d++) count += phi(d);
        System.out.println(count);
    }

    static long phi(int n)
    {
        ArrayList<Integer> factors = primeFactorization(n);
        HashSet<Integer> primes = new HashSet<>();
        for (int f : factors) primes.add(f);
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
    public static ArrayList<Integer> primeFactorization(int n)
    {
        ArrayList<Integer> primeFactorization = new ArrayList<>();
        int div = 1;
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
