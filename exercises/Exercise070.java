import java.util.ArrayList;
import java.util.HashSet;

public class Exercise070 {

    public static void main(String[] args) {
        double frac, fracStar = Double.MAX_VALUE;
        long indexStar = 0;

        for (int n = 10_000_000; n >= 2; n--)
        {
            long phi = phi(n);
            frac = 1.0 * n / phi;
            if (frac < fracStar && arePermutations(n, phi))
            {
                fracStar = frac;
                indexStar = n;
                System.out.println(n);
            }
        }
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

    /**
     * This method determines whether two integers are permuations of each other.
     * @param n1 the first number.
     * @param n2 the second number.
     * @return true iff n1 is a permutation of n2.
     */
    public static boolean arePermutations(long n1, long n2)
    {
        int[] digits1 = new int[10];
        int[] digits2 = new int[10];
        for (char c1 : Long.toString(n1).toCharArray())
            digits1[c1 - '0']++;
        for (char c2 : Long.toString(n2).toCharArray())
            digits2[c2 - '0']++;
        for (int digit = 0; digit <= 9; digit++)
        {
            if (digits1[digit] != digits2[digit]) return false;
        }
        return true;
    }
}
