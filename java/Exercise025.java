import java.math.BigInteger;

public class Exercise025 {

    public static void main(String[] args) {
        BigInteger f1 = BigInteger.ONE, f2 = BigInteger.TWO;
        BigInteger f3;
        int n = 3;
        while (true) {
            n++;
            f3 = f2.add(f1);
            if (f3.toString().length() == 1_000) {
                System.out.println(n);
                System.exit(0);
            }
            f1 = f2;
            f2 = f3;
        }
    }

}
