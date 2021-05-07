import java.math.BigInteger;

public class Exercise104 {

    private static BigInteger minBI = BigInteger.valueOf(999_999_999);

    public static void main(String[] args)
    {
        BigInteger f1 = BigInteger.ONE, f2 = BigInteger.ONE;

        for (int n = 3; n <= 1_000_000; n++)
        {
            BigInteger f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            if (f3.compareTo(minBI) > 0)
            {
                BigInteger lastDigits = f3.mod(BigInteger.valueOf(10).pow(9));
                if (IsPandigital(lastDigits.toString()))
                {
                    String firstDigits = f3.toString().substring(0, 9);
                    if (IsPandigital(firstDigits))
                    {
                        System.out.println(n);
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static boolean IsPandigital(String n)
    {
        return arePermutations("123456789", n);
    }

    /**
     * This method determines whether two integers are permuations of each other.
     * @param n1 the first number.
     * @param n2 the second number.
     * @return true iff n1 is a permutation of n2.
     */
    public static boolean arePermutations(String n1, String n2)
    {
        int[] digits1 = new int[10];
        int[] digits2 = new int[10];
        for (char c1 : n1.toCharArray())
            digits1[c1 - '0']++;
        for (char c2 : n2.toCharArray())
            digits2[c2 - '0']++;
        for (int digit = 0; digit <= 9; digit++)
        {
            if (digits1[digit] != digits2[digit]) return false;
        }
        return true;
    }
}
