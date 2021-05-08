import java.util.HashSet;

public class Exercise043 {

    private static long sum;
    private static int size = 10;
    private static int[] divisors = { 2, 3, 5, 7, 11, 13, 17 };

    public static void main(String[] args) {
        sum = 0;
        generate("");
        System.out.println(sum);
    }

    public static void generate(String seq)
    {
        int n = seq.length();
        int num;
        for (int index = 1; index <= 7; index++)
        {
            if (index + 2 < seq.length())
            {
                num = Integer.parseInt(seq.substring(index, index + 3));
                if (num % divisors[index - 1] != 0) return;
            }
        }

        if (n == size)
        {
            sum += Long.parseLong(seq);
            return;
        }

        // n <= size here
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i <= 9; i++) numbers.add(i);
        for (char c : seq.toCharArray()) numbers.remove(c - '0');
        for (int number : numbers)
            generate(seq + Integer.toString(number));
    }


}
