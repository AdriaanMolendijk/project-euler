import java.math.BigInteger;

public class Exercise020 {

    public static void main(String[] args) {
        int sum = 0;
        BigInteger num = BigInteger.ONE;
        for (int f = 1; f <= 100; f++) num = num.multiply(BigInteger.valueOf(f));
        for (char c : num.toString().toCharArray()) sum += (c - '0');
        System.out.println(sum);
    }

}
