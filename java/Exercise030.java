public class Exercise030 {

    public static void main(String[] args) {
        int sum = 0;
        for (int l = 2; l < 1_000_000; l++)
        {
            if (l == sumDigits5(l))
            {
                sum += l;
            }
        }
        System.out.println(sum);
    }

    public static int sumDigits5(long n)
    {
        int sum = 0;
        for (char c : Long.toString(n).toCharArray())
        {
            int digit = c - '0';
            sum += Math.pow(digit,5);
        }
        return sum;
    }
}
