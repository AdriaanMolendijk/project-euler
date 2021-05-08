import java.util.ArrayList;

public class Exercise205 {

    private static ArrayList<String> peters = new ArrayList<String>();
    private static ArrayList<String> colins = new ArrayList<String>();

    public static void main(String[] args)
    {
        generatePeter("");
        generateColin("");
        double[] p = new double[36];
        double[] c = new double[36];
        int sum;

        for (String colin : colins)
        {
            sum = getSum(colin);
            c[sum - 1]++;
        }

        for (String peter : peters)
        {
            sum = getSum(peter);
            p[sum - 1]++;
        }

        for (int i = 0; i < 36; i++)
        {
            c[i] = c[i] / colins.size();
            p[i] = p[i] / peters.size();
        }

        double prob = 0.0;
        for (int i = 0; i < 36; i++)
        {
            for (int j = 0; j < i; j++)
            {
                prob += p[i] * c[j];
            }
        }
        System.out.println(prob);
    }

    static void generatePeter(String seq)
    {
        if (seq.length() == 9)
        {
            peters.add(seq);
            return;
        }
        for (int i = 1; i <= 4; i++) generatePeter(seq + Integer.toString(i));
    }

    static void generateColin(String seq)
    {
        if (seq.length() == 6)
        {
            colins.add(seq);
            return;
        }
        for (int i = 1; i <= 6; i++) generateColin(seq + Integer.toString(i));
    }

    static int getSum(String seq)
    {
        int sum = 0;
        for (char c : seq.toCharArray()) sum += c - '0';
        return sum;
    }

}
