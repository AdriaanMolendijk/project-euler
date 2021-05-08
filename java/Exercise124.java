import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Exercise124 {

    public static void main(String[] args)
    {
        ArrayList<Number> numbers = new ArrayList<Number>();
        for (int n = 1; n <= 100_000; n++)
        {
            numbers.add(new Number(n, Rad(n)));
        }

        Collections.sort(numbers);
        Number output = numbers.get(10_000 - 1);
        System.out.println(output.index);
    }

    static long Rad(long n)
    {
        if (n == 1) return 1;
        ArrayList<Long> factors = primeFactorization(n);
        HashSet<Long> primes = new HashSet<>();
        for (long f : factors) primes.add(f);
        long prod = 1;
        for (long p : primes)
        prod *= p;
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

    static class Number implements Comparable<Number>
    {
        private int index;
        private long rad;

        public Number(int index, long rad)
        {
            this.index = index;
            this.rad = rad;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public long getRad() {
            return rad;
        }

        public void setRad(int rad) {
            this.rad = rad;
        }

        @Override
        public int compareTo(Number o) {
            if (rad == o.getRad())
                return Integer.compare(index, o.getIndex());
            return Long.compare(rad, o.getRad());
        }
    }

}
