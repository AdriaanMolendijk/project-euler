import java.util.ArrayList;

public class Exercise033 {

    public static void main(String[] args) {
        double f1, f2;
        int numExp, denomExp;
        ArrayList<Integer> solNums = new ArrayList();
        ArrayList<Integer> solDenoms = new ArrayList();

        for (int num = 10; num <= 99; num++)
        {
            for (int denom = num + 1; denom <= 99; denom++)
            {
                f1 = num * 1.0 / denom;
                if (num % 10 == denom / 10)
                {
                    numExp = num / 10;
                    denomExp = denom % 10;
                    f2 = numExp * 1.0 / denomExp;
                    if (f1 == f2)
                    {
                        solNums.add(numExp);
                        solDenoms.add(denomExp);
                    }
                }
            }
        }

        double prod = 1;
        for (int n : solNums) prod *= n;
        for (int d : solDenoms) prod /= d;
        System.out.println(prod);
    }

}
