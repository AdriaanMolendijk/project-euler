public class Exercise014 {

    public static void main(String[] args) {
        int maxNum = 0, maxIndex = 0;
        for (int i = 1; i <= 1_000_000; i++)
        {
            int num = collatz(i);
            if (num > maxNum)
            {
                maxNum = num;
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }

    public static int collatz(long n)
    {
        if (n == 1) return 1;

        // n >= 2 here
        if (n % 2 == 0) return 1 + collatz(n / 2);
        return 1 + collatz((3*n+1)/2);
    }
}
