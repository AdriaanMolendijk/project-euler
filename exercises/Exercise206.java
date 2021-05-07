import java.math.BigInteger;

public class Exercise206 {

    private static String bluePrint = "1_2_3_4_5_6_7_8_9_0";

    public static void main(String[] args)
    {
        for (long l = 0; l <= 10_000_000_000L; l += 10)
        {
            BigInteger square = BigInteger.valueOf(l).multiply(BigInteger.valueOf(l));
            if (isValid(square))
            {
                System.out.println(l);
                System.exit(0);
            }
        }
    }

    public static boolean isValid(BigInteger n)
    {
        int l = n.toString().length();
        if (bluePrint.length() != l) return false;

        char c;
        for (int i = 0; i < l; i++)
        {
            c = bluePrint.charAt(i);
            if (c == '_') continue;
            if (c != n.toString().charAt(i)) return false;
        }
        return true;
    }

}
