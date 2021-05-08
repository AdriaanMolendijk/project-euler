import java.math.BigInteger;

public class Exercise016 {

    public static void main(String[] args) {
        int sum = 0;
        BigInteger num = BigInteger.ONE;
        for (int pow = 1; pow <= 1_000; pow++) {
            num = num.multiply(BigInteger.TWO);
        }
        for (char d : num.toString().toCharArray())
            sum += (d - '0');
        System.out.println(sum);
    }

}
