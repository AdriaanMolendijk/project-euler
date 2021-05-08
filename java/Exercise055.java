import java.math.BigInteger;

public class Exercise055 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 10_000; i++)
        {
            if (isLychrel(i)) count++;
        }
        System.out.println(count);
    }

    public static boolean isLychrel(int n)
    {
        int iter = 0;
        BigInteger num = BigInteger.valueOf(n);
        BigInteger numReverse;

        while (iter == 0 || !isPalindrome(num.toString()))
        {
            iter++;
            if (iter >= 50) return true;
            numReverse = new BigInteger(reverse(num.toString()));
            num = num.add(numReverse);
        }
        return false;
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
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
