public class Exercise034 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i <= 10_000_000; i++)
        {
            if (i == sumDigitFactorial(i))
            {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static int sumDigitFactorial(int n)
    {
        int sum = 0, digit;
        for (char c : Integer.toString(n).toCharArray())
        {
            digit = c - '0';
            sum += factorial(digit);
        }
        return sum;
    }

    public static int factorial(int digit)
    {
        if (digit < 0 || digit >= 10) throw new IllegalArgumentException("Digit is not a single digit");
        if (digit == 0) return 1;
        return digit * factorial(digit - 1);
    }
}
