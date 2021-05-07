import java.util.ArrayList;
import java.util.Collections;

public class Exercise091 {

    private static Coord _origin = new Coord(0, 0);

    public static void main(String[] args)
    {
        int size = 50;
        ArrayList<Coord> grid = new ArrayList<Coord>();
        for (int x = 0; x <= size; x++)
        {
            for (int y = 0; y <= size; y++)
            {
                if (x == 0 && y == 0) continue;
                grid.add(new Coord(x, y));
            }
        }

        int count = 0;
        for (Coord a : grid)
        {
            for (Coord b : grid)
            {
                if (IsTriangle(a, b)) count++;
            }
        }

        System.out.println(count / 2);
    }

    public static boolean IsTriangle(Coord a, Coord b)
    {
        if (a.equals(b)) return false;
        ArrayList<Double> distances = new ArrayList<Double>();
        distances.add(getDistance(a, _origin));
        distances.add(getDistance(b, _origin));
        distances.add(getDistance(a, b));
        Collections.sort(distances);
        double d1 = distances.get(0), d2 = distances.get(1), d3 = distances.get(2);
        double approx = Math.abs(d1 * d1 + d2 * d2 - d3 * d3);
        return approx < Math.pow(10, -5);
    }

    public static double getDistance(Coord a, Coord b)
    {
        double distX = a.getX() - b.getX();
        double distY = a.getY() - b.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    public static class Coord {

        private int x;
        private int y;

        public Coord(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean equals(Coord o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }

        public String toString()
        {
            return "(" + x + "," + y + ")";
        }
    }

}
