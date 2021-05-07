import java.util.ArrayList;
import java.util.HashSet;

public class Exercise068 {

    private static int size = 10;
    private static int count = 0;

    public static void main(String[] args)
    {
        generate(new ArrayList());
    }

    static void generate(ArrayList<Integer> seq)
    {
        if (seq.size() == size)
        {
            String sol = getSol(seq);
            if (!sol.equals("INVALID"))
            {
                count++;
                System.out.println(count + ": " + sol);
            }
            return;
        }

        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= size; i++) numbers.add(i);
        for (int s : seq) numbers.remove(s);
        for (int num : numbers)
        {
            ArrayList newSeq = new ArrayList();
            for (int s : seq) newSeq.add(s);
            newSeq.add(num);
            generate(newSeq);
        }
    }

    public static String getSol(ArrayList<Integer> seq)
    {
        if (seq.size() != size)
            throw new IllegalArgumentException("The input sequence is not a solution, since its size is not equal to " +
                    size);
        int[] indices = { 0, 1, 2, 3, 2, 4, 5, 4, 6, 7, 6, 8, 9, 8, 1 };
        // int[] indices = {0,1,2,3,2,4,5,4,1}; // indices for the 5-gon ring

        int sum = seq.get(indices[0]) + seq.get(indices[1]) + seq.get(indices[2]);
        int digit = seq.get(indices[0]);
        int nextSum, nextDigit;
        for (int i = 1; i <= 4; i++)
        {
            nextSum = seq.get(indices[3 * i]) + seq.get(indices[3 * i + 1]) + seq.get(indices[3 * i + 2]);
            if (nextSum != sum) return "INVALID";
            nextDigit = seq.get(indices[3 * i]);
            if (nextDigit < digit) return "INVALID";
        }

        String output = "";
        for (int index : indices)
        output += seq.get(index);
        return output;
    }
}
