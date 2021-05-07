public class Exercise092 {

    public static void main(String[] args)
    {
        int count = 0;
        for (long l = 1; l <= 10_000_000; l++)
        {
            if (sequence(l) == 89) count++;
        }
        System.out.println(count);
    }

    static long sumSquareDigits(long l)
    {
        int sum = 0, digit;
        for (char c : Long.toString(l).toCharArray())
        {
            digit = c - '0';
            sum += digit * digit;
        }
        return sum;
    }

    static long sequence(long l)
    {
        if (l == 1 || l == 89) return l;
        return sequence(sumSquareDigits(l));
    }
}
