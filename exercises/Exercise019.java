public class Exercise019 {

    private static String[] weekdays = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };
    private static String[] months =
            {"jan", "feb", "march", "april", "may", "jun", "jul", "aug", "sept", "okt", "nov", "dev"};
    private static int[] monthLimits = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args)
    {
        int count = 0;
        int dayMonth = 1, dayWeek = 0, month = 0, year = 1900;

        for (int i = 1; i <= 100_000; i++)
        {
            // check if day meets counting criteria
            if (dayWeek == 6 && dayMonth == 1 && year >= 1901 && year <= 2000) count++;

            // continue to next day
            dayWeek = (dayWeek + 1) % 7;
            int limit = monthLimits[month];
            dayMonth++;
            if (dayMonth > limit + leapYearDay(month, year))
            {
                dayMonth = 1;
                month++;
                if (month == 12)
                {
                    month = 0;
                    year++;
                }
            }
            if (year == 2001) break;
        }

        System.out.println(count);
    }

    public static int leapYearDay(int month, int year)
    {
        if (month == 1 && isLeapYear(year)) return 1;
        return 0;
    }

    public static boolean isLeapYear(int year)
    {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

}
