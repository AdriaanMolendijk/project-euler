public class Exercise075 {

    public static void main(String[] args)
    {
        int limit = 1_500_000;
        int[] numSolutions = new int[limit];

        /*
         * we have a <= b <= c, a^2 + b^2 = c^2, a + b + c = p and p <= limit.
         * Hence
         *  a <= limit / 3
         *  b <= limit / 2
         */
        for (long a = 1; a <= limit / 3; a++)
        {
            if (a % (limit / 1000) == 0) System.out.println(100.0 * a / limit + " %");
            for (long b = a; b <= (limit - a) / 2; b++)
            {
                if (a + b > limit - b) break;
                long square = a * a + b * b;
                if (isSquare(square))
                {
                    long c = (long)Math.sqrt(square);
                    int sum = (int) (a + b + c);
                    if (sum > limit) break;
                    numSolutions[sum - 1]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= limit; i++)
        {
            if (numSolutions[i - 1] == 1) count++;
        }
        System.out.println(count);
    }

    public static boolean isSquare(long n)
    {
        long root = (long) Math.sqrt(n);
        return root * root == n;
    }

}
