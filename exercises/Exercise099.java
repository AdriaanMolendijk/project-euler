import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise099 {

    public static void main(String[] args) throws FileNotFoundException {
        String[] numbers;
        double val, maxVal = 0;
        int maxIndex = 0;
        Scanner in = new Scanner(new File("Exercise099.txt"));
        for (int i = 1; i <= 1000; i++)
        {
            String line = in.nextLine();
            numbers = line.split(",");
            val = Integer.parseInt(numbers[1]) * Math.log(Integer.parseInt(numbers[0]));
            if (val > maxVal)
            {
                maxVal = val;
                maxIndex = i;
            }
        }
        System.out.println((maxIndex));
    }

}
