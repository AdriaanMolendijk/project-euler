import java.util.HashSet;

public class Exercise095 {

    public static void main(String[] args)
    {
        int n, maxN = 0, maxIndex = 0;
        for (int i = 2; i <= 15_000; i++)
        {
            n = amicableChain(i);
            if (n > maxN)
            {
                maxN = n;
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }

    static int amicableChain(long n)
    {
        HashSet<Long> chain = new HashSet<>();
        long nStart = n;
        int count = 0;
        while (true)
        {
            if (n > 1_000_000) return -1;
            n = sumProperDivs(n);
            if (chain.contains(n)) break;
            chain.add(n);
            count++;
        }

        if (!chain.contains(nStart)) return -1;
        return count;

    }

    static int sumProperDivs(long n)
    {
        int sum = 0;
        for (int i = 1; i < n; i++)
        {
            if (n % i == 0) sum += i;
        }
        return sum;
    }
}
