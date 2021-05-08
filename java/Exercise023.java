import java.util.ArrayList;

public class Exercise023 {

    public static void main(String[] args) {
        int maxAbundant = 28123;
        ArrayList<Integer> abundants = new ArrayList<>();
        int[] numbers = new int[maxAbundant];

        for (int i = 1; i <= maxAbundant; i++)
        {
            numbers[i-1] = i;
            if (isAbundant(i)) abundants.add(i);
        }

        int pairSum = 0;
        for (int i : abundants)
        {
            for (int j : abundants)
            {
                pairSum = i + j;
                if (pairSum <= maxAbundant)
                    numbers[pairSum - 1] = 0;
            }
        }

        long sum = 0;
        for (int n : numbers) sum += n;
        System.out.println(sum);
    }

    public static boolean isAbundant(long n)
    {
        if (n < 1) throw new IllegalArgumentException("Input n must be >= 1");
        int sum = 0;
        for (int i = 1; i < n; i++)
        {
            if (n % i == 0) sum += i;
        }
        return sum > n;
    }

}
