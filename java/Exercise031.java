import java.util.ArrayList;

public class Exercise031 {

    private static int count = 0;
    private static int limit = 200;
    private static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

    public static void main(String[] args) {
        for (int coin : coins)
        {
            ArrayList<Integer> seq = new ArrayList<>();
            seq.add(coin);
            generate(seq);
        }
        System.out.println(count);
    }

    public static void generate(ArrayList<Integer> seq)
    {
        int sum = 0;
        for (int n : seq) sum += n;
        if (sum > limit) return;
        if (sum == limit)
        {
            count++;
            return;
        }

        // sum < limit here
        for (int coin : coins)
        {
            if (coin <= seq.get(seq.size() - 1))
            {
                ArrayList<Integer> newSeq = new ArrayList<>();
                for (int s : seq) newSeq.add(s);
                newSeq.add(coin);
                generate(newSeq);
            }
        }
    }

}
