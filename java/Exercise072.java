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
