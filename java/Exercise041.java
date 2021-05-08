public class Exercise041 {

    public static void main(String[] args) {
        int limit = 10_000_000;
        boolean[] sieve = primeSieve(limit);
        String oneToN = "123456789";
        for (int i = 1; i <= limit; i++)
        {
            if (sieve[i - 1])
            {
                if (arePermutations(i, Integer.parseInt(oneToN.substring(0, Integer.toString(i).length()))))
                {
                    System.out.println(i);
                }
            }
        }
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

    /**
     * This method returns the prime sieve of all numbers up to a certain limit;
     * @param limit the limit of the prime sieve.
     * @return a boolean[] representing the sieve up to limit.
     */
    public static boolean[] primeSieve(int limit)
    {
        if (limit <= 0) throw new IllegalArgumentException("Limit must be >= 1");

        // limit >= 1 here
        boolean[] sieve = new boolean[limit];
        for (int i = 2; i <= limit; i++) sieve[i-1] = true;

        for (int i = 2; i <= Math.sqrt(limit); i++)
        {
            if (sieve[i-1])
            {
                int j = i * i;
                while (j <= limit)
                {
                    sieve[j-1] = false;
                    j += i;
                }
            }
        }

        return sieve;
    }
}
