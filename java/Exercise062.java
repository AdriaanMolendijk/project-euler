import java.util.ArrayList;

public class Exercise062 {

    public static void main(String[] args) {
        int limit = 10_000;
        ArrayList<Long> cubics = new ArrayList();
        for (long i = 1; i <= limit; i++) cubics.add(i * i * i);
        int n = cubics.size();

        for (long c1 : cubics)
        {
            for (long c2 : cubics)
            {
                if (c2 <= c1 || !arePermutations(c1, c2)) continue;
                for (long c3 : cubics)
                {
                    if (c3 <= c2 || !arePermutations(c2, c3)) continue;
                    for (long c4 : cubics)
                    {
                        if (c4 <= c3 || !arePermutations(c3, c4)) continue;
                        for (long c5 : cubics)
                        {
                            if (c5 <= c4 || !arePermutations(c4, c5)) continue;
                            System.out.println(c1);
                            System.exit(0);
                        }
                    }
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
