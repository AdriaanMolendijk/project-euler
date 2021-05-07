import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise102 {

    private static Coord _origin = new Coord(0, 0);

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Exercise102.txt"));
        String[] numbers;
        int count = 0;
        for (int i = 1; i <= 1000; i++)
        {
            String line = in.nextLine();
            numbers = line.split(",");
            Coord a = new Coord(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            Coord b = new Coord(Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]));
            Coord c = new Coord(Integer.parseInt(numbers[4]), Integer.parseInt(numbers[5]));
            if (containsOrigin(a, b, c)) count++;
        }
        System.out.println(count);
    }

    public static boolean containsOrigin(Coord a, Coord b, Coord c)
    {
        double area = area(a, b, c);
        double area1 = area(_origin, b, c);
        double area2 = area(a, _origin, c);
        double area3 = area(a, b, _origin);
        return Math.abs(area1 + area2 + area3 - area) < Math.pow(10, -2);
    }

    static double area(Coord a, Coord b, Coord c)
    {
        return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
    }
}
