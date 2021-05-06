public class Exercise021 {

    public static void main(String[] args) {
        int sum = 0;
        for (int n = 1; n <= 10_000; n++)
        {
            int num = sumDivs(n);
            if (n != num && sumDivs(num) == n)
            {
                sum += n;
            }
        }
        System.out.println(sum);
    }

    public static int sumDivs(int n)
    {
        int sum = 0;
        for (int i = 1; i < n; i++)
        {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

}
