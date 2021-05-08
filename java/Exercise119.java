import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise119 {

    public static void main(String[] args)
    {
        ArrayList<BigInteger> targets = new ArrayList<BigInteger>();

        int limit = 250;
        for (int i = 1; i <= limit; i++)
        {
            for (int pow = 1; pow <= limit; pow++)
            {
                BigInteger val = BigInteger.valueOf(i).pow(pow);
                if (val.toString().length() >= 2)
                {
                    if (SumDigits(val) == i)
                    {
                        targets.add(val);
                    }
                }
            }
        }

        Collections.sort(targets);
        System.out.println(targets.get(29));
    }

    static int SumDigits(BigInteger n)
    {
        int sum = 0;
        for (char c : n.toString().toCharArray())
        sum += c - '0';
        return sum;
    }
}
