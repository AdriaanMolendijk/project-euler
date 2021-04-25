public class Exercise004 {

    public static void main(String[] args) {
        int c, maximum = 0;
        for (int a = 100; a <= 999; a++)
        {
            for (int b = a; b <= 999; b++)
            {
                c = a * b;
                if (c > maximum && isPalindrome(Integer.toString(c)))
                {
                    System.out.println(c);
                    maximum = c;
                }
            }
        }
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
