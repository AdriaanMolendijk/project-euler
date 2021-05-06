import java.util.HashSet;

public class Exercise024 {

    private static int size = 9;
    private static int count;

    public static void main(String[] args) {
        count = 0;
        generate("");
    }

    public static void generate(String seq)
    {
        if (seq.length() == size + 1)
        {
            count++;
            if (count == 1_000_000)
            {
                System.out.println(seq);
                System.exit(0);
            }
            return;
        }

        /*
         * recursively call generate(seq + i) with all numbers i from 0,1,2,...,size
         * that have not been used in string seq yet
         */
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i <= size; i++) numbers.add(i);
        for(char c : seq.toCharArray())
        numbers.remove(c - '0');

        for (int num : numbers)
        generate(seq + num);
    }
}
