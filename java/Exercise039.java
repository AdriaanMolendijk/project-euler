public class Exercise039 {

    public static void main(String[] args) {
        int maxP = 0, maxSol = 0;
        for (int p = 1; p <= 1000; p++)
        {
            int numSol = numSolutions(p);
            if (numSol > maxSol)
            {
                maxSol = numSol;
                maxP = p;
            }
        }
        System.out.println(maxP);
    }

    public static int numSolutions(int p)
    {
        int count = 0;
        // we have a <= b <= c and a + b + c = p, thus a <= p/3 and b <= p/2
        for (int a = 1; a <= p/3; a++)
        {
            for (int b = a; b <= p/2; b++)
            {
                int c = p - b - a;
                if (a * a + b * b == c * c)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
