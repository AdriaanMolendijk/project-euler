import java.math.BigInteger;

public class Exercise063 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 9; i++)
        {
            for (int pow = 1; pow <= 100; pow++)
            {
                BigInteger val = BigInteger.valueOf(i).pow(pow);
                if (val.toString().length() == pow)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
