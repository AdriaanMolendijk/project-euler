import java.util.ArrayList;

public class Exercise077 {

    private static boolean[] _sieve;
    private static int _target;
    private static int _count;

    public static void main(String[] args)
    {
        int limit = 100;
        _sieve = primeSieve(limit);

        for (int n = 1; n <= limit; n++)
        {
            _count = 0;
            _target = n;
            generate(new ArrayList<Integer>());
            System.out.println(n + ": " + _count);
            if (_count >= 5000) break;
        }
    }

    static void generate(ArrayList<Integer> seq)
    {
        int sum = 0;
        for (int s : seq) sum += s;

        if (sum == _target)
        {
            _count++;
            return;
        }

        for (int i = 1; i <= _target - sum; i++)
        {
            if (_sieve[i - 1])
            {
                if (seq.size() >= 1)
                {
                    if (i > (int)seq.get(seq.size() - 1)) continue;
                }
                ArrayList newSeq = new ArrayList();
                for (int s : seq) newSeq.add(s);
                newSeq.add(i);
                generate(newSeq);
            }
        }
    }

    /**
     * This method returns the prime sieve of all numbers up to a certain limit;
     * @param limit the limit of the prime sieve.
     * @return a boolean[] representing the sieve up to limit.
     */
    public static boolean[] primeSieve(int limit)
    {
        if (limit <= 0) throw new IllegalArgumentException("Limit must be >= 1");

        // limit >= 1 here
        boolean[] sieve = new boolean[limit];
        for (int i = 2; i <= limit; i++) sieve[i-1] = true;

        for (int i = 2; i <= Math.sqrt(limit); i++)
        {
            if (sieve[i-1])
            {
                int j = i * i;
                while (j <= limit)
                {
                    sieve[j-1] = false;
                    j += i;
                }
            }
        }

        return sieve;
    }
}
