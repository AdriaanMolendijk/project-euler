import java.math.BigInteger;

public class Exercise056 {

    public static void main(String[] args) {
        int maxSum = 0;
        for (int a = 1; a < 100; a++)
        {
            for (int b = 1; b < 100; b++)
            {
                BigInteger val = BigInteger.valueOf(a).pow(b);
                maxSum = Math.max(maxSum, digitSum(val));
            }
        }
        System.out.println(maxSum);
    }

    public static int digitSum(BigInteger n)
    {
        int sum = 0;
        for (char c : n.toString().toCharArray())
            sum += c - '0';
        return sum;
    }

}
