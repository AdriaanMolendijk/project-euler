import java.util.ArrayList;
import java.util.Collections;

public class Exercise045 {

    private static ArrayList<Long> triangles = new ArrayList();
    private static ArrayList<Long> pentagons = new ArrayList();
    private static ArrayList<Long> hexagons = new ArrayList();

    public static void main(String[] args) {
        int limit = 100_000;
        for (long n = 1; n <= limit; n++)
        {
            triangles.add(n * (n + 1) / 2);
            pentagons.add(n * (3 * n - 1) / 2);
            hexagons.add(n * (2 * n - 1));
        }

        for (long triangle : triangles)
        {
            if (isPentagonal(triangle) && isHexagonal(triangle))
            {
                System.out.println(triangle);
            }
        }
    }

    public static boolean isHexagonal(long n)
    {
        if (Collections.binarySearch(hexagons, n) >= 0) return true;
        return false;
    }

    public static boolean isPentagonal(long n)
    {
        if (Collections.binarySearch(pentagons, n) >= 0) return true;
        return false;
    }

}
