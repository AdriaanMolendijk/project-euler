public class Exercise038 {

    public static void main(String[] args) {
        String concat;
        for (int i = 1; i <= 9999; i++)
        {
            concat = "";
            for (int n = 1; n <= 6; n++)
            {
                int prod = i * n;
                concat += Integer.toString(prod);
                if (concat.length() > 9) break;
                if (arePermutations(123_456_789L, Integer.parseInt(concat)))
                {
                    System.out.println(concat);
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
