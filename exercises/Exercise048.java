import java.math.BigInteger;

public class Exercise048 {

    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++)
        {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        int l = sum.toString().length();
        System.out.println(sum.toString().substring(l-10,l));
    }
}
