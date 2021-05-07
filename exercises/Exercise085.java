public class Exercise085 {

    public static void main(String[] args)
    {
        int limit = 100;
        long curr, distance, best = 2_000_001;

        for (int a = 1; a <= limit; a++)
        {
            for (int b = a; b <= limit; b++)
            {

                curr = getRectangles(a, b);
                distance = Math.abs(2_000_000 - curr);
                if (distance < best)
                {
                    best = distance;
                    System.out.println(a * b);
                }
            }
        }
    }

    public static long getRectangles(int rows, int cols)
    {
        int number;
        int total = 0;
        for (int width = 1; width <= cols; width++)
        {
            for (int height = 1; height <= rows; height++)
            {
                number = (cols - width + 1) * (rows - height + 1);
                total += number;
            }
        }
        return total;
    }
}
