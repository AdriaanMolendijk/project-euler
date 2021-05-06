import java.math.BigInteger;

public class Exercise053 {

    public static void main(String[] args) {
        int count = 0;
        BigInteger val;
        for (int n = 1; n <= 100; n++)
        {
            for (int r = 0; r <= n; r++)
            {
                val = choose(n, r);
                if (val.compareTo(BigInteger.valueOf(1_000_000)) > 0)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static BigInteger choose(int n, int r)
    {
        if (r < 0 || r > n)
            throw new IllegalArgumentException("Not valid binomial coefficient, we dont have 0 <= r <= n.");
        BigInteger val = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
        {
            val = val.multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= r; i++)
        {
            val = val.divide(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= n - r; i++)
        {
            val = val.divide(BigInteger.valueOf(i));
        }
        return val;
    }

}
