import java.math.BigInteger;

public class Exercise097 {

    public static void main(String[] args) {
        BigInteger mersenne = new BigInteger("28433");
        for (int i = 1; i <= 7_830_457; i++)
        {
            mersenne = mersenne.multiply(BigInteger.TWO);
            mersenne = mersenne.mod(BigInteger.valueOf(10).pow(10));
        }
        mersenne = mersenne.add(BigInteger.ONE);
        System.out.println(mersenne);
    }
}
