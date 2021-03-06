import java.util.ArrayList;
import java.util.HashSet;

public class Exercise073 {

    public static void main(String[] args) {
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();

        Fraction current;
        double val;

        for (int d = 12_000; d >= 2; d--)
        {
            ArrayList<Integer> relPrimes = getRelPrimes(d);
            for (int p : relPrimes)
            {
                current = new Fraction(p, d);
                val = current.getValue();
                if (val > 1.0 / 3.0 && val < 0.5)
                {
                    fractions.add(current);
                }
            }
        }
        System.out.println(fractions.size());
    }

    public static ArrayList<Integer> getRelPrimes(int n)
    {
        ArrayList<Integer> factors = primeFactorization(n);
        HashSet<Integer> primes = new HashSet<>();
        for (int f : factors) primes.add(f);

        ArrayList<Integer> relPrimes = new ArrayList<Integer>();
        for (int i = 1; i < n; i++)
        {
            boolean found = false;
            for (long p : primes)
            {
                if (i % p == 0)
                {
                    found = true;
                    break;
                }
            }
            if (!found) relPrimes.add(i);
        }
        return relPrimes;
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

    public static class Fraction implements Comparable<Fraction> {

        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator)
        {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }

        public double getValue()
        {
            return (double) numerator / denominator;
        }

        public int compareTo(Fraction other)
        {
            return Double.compare(getValue(), other.getValue());
        }

        public String toString()
        {
            return "(" + numerator + "," + denominator + ")";
        }

    }
}
