public class Exercise009 {

    public static void main(String[] args) {
        // we have a <= b <= c and a + b + c = 1000, thus a <= 334 and b <= 500
        for (int a = 1; a <= 334; a++)
        {
            for (int b = a; b <= 500; b++)
            {
                int c = 1000 - b - a;
                if (a * a + b * b == c * c)
                {
                    System.out.println(a * b * c);
                }
            }
        }
    }
}
