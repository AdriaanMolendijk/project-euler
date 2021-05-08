import java.math.BigInteger;
import java.util.HashSet;

public class Exercise029 {

    public static void main(String[] args) {
        HashSet<BigInteger> numbers = new HashSet<BigInteger>();
        for (int a = 2; a <= 100; a++)
        {
            for (int b = 2; b <= 100; b++)
            {
                numbers.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.println(numbers.size());
    }
}
