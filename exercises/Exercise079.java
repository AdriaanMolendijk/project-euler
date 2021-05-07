import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise079 {

    private static String[] logins;

    public static void main(String[] args) throws FileNotFoundException {
        int size = 50;
        Scanner in = new Scanner(new File("Exercise079.txt"));
        logins = new String[size];
        for (int i = 0; i < size; i++)
        {
            logins[i] = in.nextLine();
        }

        for (int pw = 1; pw <= 100_000_000; pw++)
        {
            boolean found = true;
            for (String login : logins)
            {
                if (!isValid(pw, login))
                {
                    found = false;
                    break;
                }
            }
            if (found)
            {
                System.out.println(pw);
                System.exit(0);
            }
        }
    }

    public static boolean isValid(int pw, String login)
    {
        String pass = Integer.toString(pw);
        int length = pass.length();
        int currIndex = -1;
        for (char c : login.toCharArray())
        {
            int index = pass.indexOf(c);
            if (index <= currIndex) return false;
            currIndex = index;
        }
        return true;
    }

}
