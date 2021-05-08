import java.util.ArrayList;

public class Exercise051 {

    private static boolean[] sieve;
    private static int limit;
    private static ArrayList<String> starTemplates = new ArrayList();

    public static void main(String[] args) {
        limit = 1_000_000;
        sieve = primeSieve(limit);

        int numPrimes;
        for (int n = 2; n <= limit; n++)
        {
            if (n % 100 == 0) System.out.println(n);
            starTemplates = new ArrayList();
            GenerateTemplates(n, "");
            for (String star : starTemplates)
            {
                numPrimes = getNumPrimes(star);
                if (numPrimes == 8)
                {
                    System.out.println(n + ": " + star + " " + numPrimes);
                    System.exit(0);
                }
            }
        }
    }

    public static int getNumPrimes(String star)
    {
        int count = 0;
        for (int i = 0; i <= 9; i++)
        {
            String num = star.replace("*", Integer.toString(i));
            int number = Integer.parseInt(num);

            // if number contains less digits continue (e.g. *3 -> 03 = 3 is not a valid substitution)
            if (Integer.toString(number).length() < star.length()) continue;
            // check number > 0 (e.g. ** -> 00 provides index out of bounds error)
            if (number == 0) continue;

            if (sieve[Integer.parseInt(num) - 1]) count++;
        }
        return count;
    }

    static void GenerateTemplates(int n, String seq)
    {
        int length = seq.length();
        if (length == Integer.toString(n).length())
        {
            starTemplates.add(seq);
            return;
        }

        // length < size here
        GenerateTemplates(n, seq + Integer.toString(n).charAt(length));
        GenerateTemplates(n, seq + "*");
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
