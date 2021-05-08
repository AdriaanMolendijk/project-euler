import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Exercise061 {

    private static int _limit = 10_000;
    private static ArrayList<Integer> triangles = new ArrayList();
    private static ArrayList<Integer> squares = new ArrayList();
    private static ArrayList<Integer> pentagonals = new ArrayList();
    private static ArrayList<Integer> hexogonals = new ArrayList();
    private static ArrayList<Integer> heptagonals = new ArrayList();
    private static ArrayList<Integer> octagonals = new ArrayList();
    private static ArrayList<Integer> numbers = new ArrayList();

    public static void main(String[] args) {
        HashSet<Integer> allNumbers = new HashSet<>();
        for (int i = 1; i <= _limit; i++)
        {
            int num = i * (i + 1) / 2;
            if (num > _limit) break;
            triangles.add(num);
            allNumbers.add(num);
        }
        for (int i = 1; i <= _limit; i++)
        {
            int num = i * i;
            if (num > _limit) break;
            squares.add(num);
            allNumbers.add(num);
        }
        for (int i = 1; i <= _limit; i++)
        {
            int num = i * (3 * i - 1) / 2;
            if (num > _limit) break;
            pentagonals.add(num);
            allNumbers.add(num);
        }
        for (int i = 1; i <= _limit; i++)
        {
            int num = i * (2 * i - 1);
            if (num > _limit) break;
            hexogonals.add(num);
            allNumbers.add(num);
        }
        for (int i = 1; i <= _limit; i++)
        {
            int num = i * (5 * i - 3) / 2;
            if (num > _limit) break;
            heptagonals.add(num);
            allNumbers.add(num);
        }

        for (int i = 1; i <= _limit; i++)
        {
            int num = i * (3 * i - 2);
            if (num > _limit) break;
            octagonals.add(num);
            allNumbers.add(num);
        }

        for (int num : allNumbers) numbers.add(num);
        Collections.sort(numbers);

        for (int i1 = 11; i1 <= 99; i1++)
        {
            for (int i2 = 11; i2 <= 99; i2++)
            {
                int num1 = 100 * i1 + i2;
                if (Collections.binarySearch(numbers, num1) < 0) continue;
                for (int i3 = 11; i3 <= 99; i3++)
                {
                    int num2 = 100 * i2 + i3;
                    if (Collections.binarySearch(numbers, num2) < 0) continue;
                    for (int i4 = 11; i4 <= 99; i4++)
                    {
                        int num3 = 100 * i3 + i4;
                        if (Collections.binarySearch(numbers, num3) < 0) continue;
                        for (int i5 = 11; i5 <= 99; i5++)
                        {
                            int num4 = 100 * i4 + i5;
                            if (Collections.binarySearch(numbers, num4) < 0) continue;
                            for (int i6 = 11; i6 <= 99; i6++)
                            {
                                int num5 = 100 * i5 + i6;
                                if (Collections.binarySearch(numbers, num5) < 0) continue;
                                int num6 = 100 * i6 + i1;
                                if (Collections.binarySearch(numbers, num6) < 0) continue;

                                HashSet<Integer> potentials = new HashSet<>();
                                potentials.add(num1);
                                potentials.add(num2);
                                potentials.add(num3);
                                potentials.add(num4);
                                potentials.add(num5);
                                potentials.add(num6);
                                if (potentials.size() < 6) continue;

                                HashSet<Integer> types = new HashSet<>();
                                types.add(numberOfType(potentials, triangles));
                                types.add(numberOfType(potentials, squares));
                                types.add(numberOfType(potentials, pentagonals));
                                types.add(numberOfType(potentials, hexogonals));
                                types.add(numberOfType(potentials, heptagonals));
                                types.add(numberOfType(potentials, octagonals));
                                if (types.contains(-1) || types.size() < 6) continue;

                                int sum = num1 + num2 + num3 + num4 + num5 + num6;
                                System.out.println(sum + " ");
                                for (int p : potentials)
                                System.out.println(p + " ");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }

    public static int numberOfType(HashSet<Integer> potentials, ArrayList type)
    {
        for (int p : potentials)
        {
            if (type.contains(p)) return p;
        }
        return -1;
    }

}
