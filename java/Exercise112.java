public class Exercise112 {

    public static void main(String[] args)
    {
        double ratio;
        int count = 0, total = 0;
        for (int l = 1; l <= 10_000_000; l++)
        {
            if (isBouncy(l)) count++;
            ratio = 1.0 * count / l;
            if (ratio >= 0.99)
            {
                System.out.println(l);
                System.exit(0);
            }
        }
    }

    public static boolean isBouncy(long l)
    {
        return !isIncreasing(l) && !isDecreasing(l);
    }

    public static boolean isDecreasing(long l)
    {
        String num = Long.toString(l);
        int size = num.length();
        for (int i = 0; i < size - 1; i++)
        {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            if (c2 > c1) return false;
        }
        return true;
    }

    public static boolean isIncreasing(long l)
    {
        String num = Long.toString(l);
        int size = num.length();
        for (int i = 0; i < size - 1; i++)
        {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            if (c2 < c1) return false;
        }
        return true;
    }
}
