import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise059 {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static String[] numbers;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("Exercise059.txt"));
        numbers = in.nextLine().split(",");

        double maxVal = 0;
        int sum = 0;
        for (char a : alphabet.toCharArray())
        {
            for (char b : alphabet.toCharArray())
            {
                for (char c : alphabet.toCharArray())
                {
                    String passwd = "" + a + b + c;
                    String key = getKey(passwd);
                    String plain = decrypt(key);
                    double val = getMatchVal(plain);
                    if (val > maxVal)
                    {
                        maxVal = val;
                        sum = 0;
                        for (char pl : plain.toCharArray()) sum += pl;
                        System.out.println(passwd + " " + sum + " " + val);
                    }
                }
            }
        }

    }

    static double getMatchVal(String text)
    {
        int count = 0;
        for (char c : text.toCharArray())
        {
            boolean isLower = c >= 97 && c <= 122;
            boolean isUpper = c >= 65 && c <= 90;
            if (isLower || isUpper) count++;
        }
        return 1.0 * count / numbers.length;
    }

    public static String decrypt(String key)
    {
        String plain = "";
        for (int i = 0; i < numbers.length; i++)
            plain += (char)(Integer.parseInt(numbers[i]) ^ key.charAt(i));
        return plain;
    }

    public static String getKey(String passwd)
    {
        String output = "";
        while (output.length() < numbers.length) output += passwd;
        return output;
    }

}
