import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise022 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Exercise022.txt"));
        String[] names = in.nextLine().split(",");
        int n = names.length;
        for (int i = 0; i < n; i++)
        {
            int length = names[i].length();
            names[i] = names[i].substring(1,length-1);
        }

        // calculate score
        Arrays.sort(names);
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += getCount(names[i]) * (i + 1);
        }
        System.out.println(sum);
    }

    public static int getCount(String name)
    {
        int sum = 0;
        for (char c : name.toCharArray()) sum += c - '@';
        return sum;
    }

}
