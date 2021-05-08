public class Exercise036 {

    public static void main(String[] args) {
        long sum = 0;
        String binary;
        for (int i = 1; i < 1_000_000; i++)
        {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i)))
            {
                sum += i;
            }
        }
        System.out.println(sum);
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
