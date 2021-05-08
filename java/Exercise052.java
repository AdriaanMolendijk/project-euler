public class Exercise052 {

    public static void main(String[] args) {
        long num;
        int numDigits;
        for (long l = 1; l <= 1_000_000; l++)
        {
            numDigits = Long.toString(l).length();
            for (int i = 2; i <= 6; i++)
            {
                num = l * i;
                if (Long.toString(num).length() != numDigits) break;
                if (!arePermutations(l, num)) break;
                if (i == 6)
                {
                    System.out.println(l);
                    System.exit(0);
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
}
