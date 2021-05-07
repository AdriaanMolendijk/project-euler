public class Exercise145 {

    public static void main(String[] args)
     {
        int num, count = 0;
        for (int i = 1; i <= 1_000_000_000; i++)
        {
            if (i % 10_000 == 0) System.out.println(i + " " + count);
            // i may not have leading zeros when reversed
            if (i % 10 != 0)
            {
                num = i + Reverse(i);
                if (HasOnlyOddDigits(num)) count++;
            }
        }
    }

    public static boolean HasOnlyOddDigits(int n)
    {
        for (char c : Integer.toString(n).toCharArray())
        {
            int digit = c - '0';
            if (digit % 2 == 0) return false;
        }
        return true;
    }
    static int Reverse(int n)
    {
        String number = Integer.toString(n);
        String revNum = new StringBuilder(number).reverse().toString();
        return Integer.parseInt(revNum);
    }
}
