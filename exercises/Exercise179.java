import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exercise179 {

    public static void main(String[] args) {
        int limit = 10_000_000, count = 0;
        int divs2 = 1;
        for (int n = 2; n <= limit; n++)
        {
            int divs1 = divs2;
            divs2 = getNumDivisors(n);
            if (divs1 == divs2) count++;
        }
        System.out.println(count);
    }

    /**
     * This method returns the number of divisors of a number.
     * @param n the number of which to count the number of divisors.
     * @return the number of divisors of n.
     */
    public static int getNumDivisors(long n)
    {
        ArrayList<Long> primeFactorization = primeFactorization(n);
        Map<Long, Integer> primes = new HashMap<Long, Integer>();
        for (long p : primeFactorization)
        {
            // check if prime is already in the mapping
            if (primes.containsKey(p))
            {
                primes.put(p, primes.get(p) + 1);
                continue;
            }
            primes.put(p,1);
        }
        int prod = 1;
        for (long key : primes.keySet())
            prod *= (primes.get(key)+1);
        return prod;
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
