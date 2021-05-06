import java.util.HashSet;

public class Exercise032 {

    public static void main(String[] args) {
        String number;
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 9999; i++)
        {
            for (int j = i; j <= 9999; j++)
            {
                int prod = i * j;
                number = i  + "" + j + "" + prod;
                if (number.length() > 9) break;
                if (arePermutations(123_456_789L, Long.parseLong(number)))
                {
                    numbers.add(prod);
                }
            }
        }

        int sum = 0;
        for (int num : numbers) sum += num;
        System.out.println(sum);
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
