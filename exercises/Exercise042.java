import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise042 {

    private static ArrayList<Integer> _triangles = new ArrayList<Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        for (int n = 1; n <= 1000; n++)
            _triangles.add(n * (n + 1) / 2);

        Scanner in = new Scanner(new File("Exercise042.txt"));
        String[] words = in.nextLine().split(",");
        int length = words.length;
        for (int i = 0; i < length; i++)
            words[i] = words[i].substring(1, words[i].length() - 1);

        int count = 0;
        for (String word : words)
        {
            int val = getValue(word);
            for (int triangle : _triangles)
            {
                if (triangle == val) count++;
            }
        }
        System.out.println(count);
    }

    static int getValue(String name)
    {
        int sum = 0;
        for (char c : name.toCharArray())
        sum += c - '@';
        return sum;
    }

}
