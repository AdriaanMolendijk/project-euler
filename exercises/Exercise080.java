import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Exercise080 {

    public static void main(String[] args) {
                MathContext mc = new MathContext(150);
        BigDecimal root;
        int sum;
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            if (!isSquare(i)) {
                root = new BigDecimal(i).sqrt(mc);
                sum = getSumDecimals(root);
                total += sum;
            }
        }
        System.out.println(total);
    }

    public static boolean isSquare(int i) {
        double root = Math.sqrt(i);
        return root == (int) root;
    }

    public static int getSumDecimals(BigDecimal d) {
        String decimals = d.toString().replaceAll("\\.", "").substring(0,100);
        BigInteger number = new BigInteger(decimals);
        int sum = 0;
        int digit;
        while (number.compareTo(BigInteger.ZERO) > 0) {
            digit = number.mod(BigInteger.TEN).intValue();
            sum += digit;
            number = number.divide(BigInteger.TEN);
        }
        return sum;
    }
}
