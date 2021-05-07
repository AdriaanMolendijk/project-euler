import java.util.ArrayList;
import java.util.HashSet;

public class Exercise125 {

    public static void main(String[] args)
    {
        long limit = (long) Math.pow(10, 8);
        ArrayList numbers = new ArrayList();
        for (int i = 1; i <= Math.sqrt(limit); i++)
        {
            numbers.add(i);
        }

        int n = numbers.size();
        long sum;
        HashSet<Long> palindromes = new HashSet<Long>();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                sum = SumSequence(numbers, i, j);
                if (sum > limit) break;
                if (isPalindrome(Long.toString(sum)))
                    palindromes.add(sum);
            }
        }

        long output = 0;
        for (long p : palindromes)
        output += p;
        System.out.println(output);
    }

    static long SumSequence(ArrayList<Integer> numbers, int l, int r)
    {
        if (l < 0 || r >= numbers.size() || l > r)
            throw new IllegalArgumentException("Incorrect input, we dont have 0 <= l <= r <= number.Count");
        long sum = 0;
        for (int index = l; index <= r; index++)
            sum += numbers.get(index) * numbers.get(index);
        return sum;
    }

    /**
     * This method determines whether a string is palindrome.
     * @param s the string on which to check the palindrome property.
     * @return true iff s is palindrome.
     */
    public static boolean isPalindrome(String s)
    {
        int l = s.length();
        if (l <= 1) return true;

        // l >= 2 here
        char c1 = s.charAt(0);
        char c2 = s.charAt(l - 1);
        return (c1 == c2) && isPalindrome(s.substring(1,l-1));
    }

}
