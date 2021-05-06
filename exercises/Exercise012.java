import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exercise012 {

    public static void main(String[] args) {
        BigInteger triangle;
        for (int i = 1; i <= 1_000_000; i++)
        {
            triangle = BigInteger.valueOf(i);
            triangle = triangle.multiply(BigInteger.valueOf(i+1));
            triangle = triangle.divide(BigInteger.TWO);
            int numDivs = getNumDivisors(triangle);
            if (numDivs >= 500)
            {
                System.out.println(triangle);
                System.exit(0);
            }
        }
    }

    public static int getNumDivisors(BigInteger n)
    {
        ArrayList<BigInteger> primeFactorization = primeFactorization(n);
        Map<BigInteger, Integer> primes = new HashMap<>();
        for (BigInteger p : primeFactorization)
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
        for (BigInteger key : primes.keySet())
            prod *= (primes.get(key)+1);
        return prod;
    }

    public static ArrayList<BigInteger> primeFactorization(BigInteger n)
    {
        ArrayList<BigInteger> primeFactorization = new ArrayList<>();
        BigInteger div = BigInteger.ONE;
        while (n.compareTo(BigInteger.ONE) > 0)
        {
            div = div.add(BigInteger.ONE);

            // if div divides l
            if (n.mod(div).equals(BigInteger.ZERO))
            {
                primeFactorization.add(div);
                n = n.divide(div);
                div = div.subtract(BigInteger.ONE);
                continue;
            }

            if (div.equals(n))
            {
                primeFactorization.add(n);
                break;
            }
        }

        return primeFactorization;
    }
}
