import java.util.HashMap;
import java.util.Map;

public class Exercise026 {

    public static void main(String[] args)
    {
        int maxLength = 0;
        for (int d = 1; d <= 1000; d++)
        {
            String representation = getRep(d);
            if (representation.contains("("))
            {
                int length = representation.indexOf(")") - representation.indexOf("(") - 1;
                if (length > maxLength)
                {
                    System.out.println(d + " " + length);
                    maxLength = length;
                }
            }
        }
    }

    public static String getRep(int d)
    {
        Map<Integer, Integer> numerators = new HashMap<>();
        String sequence = "0.";
        String output;

        int numerator = 10, index = 1;
        boolean repeats = false;
        while (true)
        {
            index++;
            numerators.put(index, numerator);
            if (numerator < d)
            {
                sequence += "0";
                numerator *= 10;
            }
            else
            {
                sequence += numerator / d;
                numerator = (numerator % d) * 10;
                if (numerator == 0)
                {
                    repeats = false;
                    break;
                }

                if (numerators.containsValue(numerator))
                {
                    repeats = true;
                    break;
                }
            }
        }

        if (repeats)
        {
            int repeatingIndex = getRepeatingIndex(numerators, numerator);
            return representation(sequence, repeatingIndex);
        }
        return sequence;
    }

    static int getRepeatingIndex(Map<Integer, Integer> numerators, int numerator)
    {
        for (int key : numerators.keySet())
        {
            if (numerator == numerators.get(key)) return key;
        }
        return -1;
    }

    public static String representation(String representation, int repeat)
    {
        return representation.substring(0, repeat) +
                "(" + representation.substring(repeat) + ")";
    }

}
