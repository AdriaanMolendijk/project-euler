public class Exercise040 {

    public static void main(String[] args) {
        StringBuilder num = new StringBuilder();
        for (int i = 1; i <= 1_000_000; i++)
        {
            num.append(Integer.toString(i));
            if (num.length() > 1_000_000) break;
        }

        int prod = 1, index = 1, digit;
        for (int i = 1; i <= 7; i++)
        {
            digit = num.charAt(index - 1) - '0';
            prod *= digit;
            index *= 10;
        }
        System.out.println(prod);
    }

}
