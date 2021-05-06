public class Exercise017 {

    private static String[] singles = {
            "one", "two", "three", "four", "five","six","seven","eight","nine","ten","eleven","twelve",
            "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
    };

    private static String[] _tenFolds = {
                    "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 1000; i++)
            total += letterCount(i);
        System.out.println(total);
    }

    public static int letterCount(int n) {
        if (n < 0 || n > 1000) throw new IllegalArgumentException("Incorrect input, we must have 0 <= n <= 1000");
        if (n == 0) return 0;
        if (n < 20) return singles[n - 1].length();
        if (n < 100)
            return _tenFolds[(n / 10) - 2].length() + letterCount(n % 10);
        if (n < 1000)
        {
            if (n % 100 == 0)
                return singles[n / 100 - 1].length() + "hundred".length();
            return singles[n / 100 - 1].length() + "hundredand".length() + letterCount(n % 100);
        }
        // n == 1000 here
        return "onethousand".length();
    }

}
