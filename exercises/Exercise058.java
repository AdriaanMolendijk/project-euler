public class Exercise058 {

    public static void main(String[] args) {
        int num = 1, term = 2, rad = 100_000;
        int numerator = 0, denominator = 1;
        double frac = 0.0;

        for (int r = 1; r <= rad; r++)
        {
            for (int t = 1; t <= 4; t++)
            {
                num += term;
                denominator++;
                if (isPrime(num)) numerator++;
                frac = (double)numerator / denominator;
            }

            term += 2;
            if (frac <= 0.10)
            {
                System.out.println(2 * r + 1);
                System.exit(0);
            }
        }
    }

    /**
     * This method determines whether an integer is prime or not.
     * @param n the number on which to perform the primality test.
     * @return true iff n is prime.
     */
    public static boolean isPrime(long n)
    {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
        {
            if (n % i == 0) return false;
            if (n % (i + 2) == 0) return false;
        }
        return true;
    }

}
