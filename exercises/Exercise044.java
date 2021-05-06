import java.util.ArrayList;
import java.util.Collections;

public class Exercise044 {

    private static ArrayList<Long> pentagons;

    public static void main(String[] args) {
        int limit = 100_000;
        pentagons = new ArrayList();
        for (long n = 1; n <= limit; n++)
        {
            pentagons.add(n * (3 * n - 1) / 2);
        }

        for (long p1 : pentagons)
        {
            for (long p2 : pentagons)
            {
                if (p2 >= p1 && isPentagonal(p1 + p2) && isPentagonal(p2 - p1))
                {
                    System.out.println(p2 - p1);
                    System.exit(0);
                }
            }
        }
    }

    public static boolean isPentagonal(long n)
    {
        if (Collections.binarySearch(pentagons, n) >= 0) return true;
        return false;
    }

}
