public class Exercise028 {

    public static void main(String[] args) {
        int num = 1, term = 2, rad = 500;
        int sum = 1;

        for (int r = 1; r <= rad; r++)
        {
            for (int t = 1; t <= 4; t++)
            {
                num += term;
                sum += num;
            }
            term += 2;
        }
        System.out.println(sum);
    }
}
