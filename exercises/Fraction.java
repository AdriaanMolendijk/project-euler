public class Fraction implements Comparable<Fraction> {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getValue()
    {
        return (double) numerator / denominator;
    }

    public int compareTo(Fraction other)
    {
        return Double.compare(getValue(), other.getValue());
    }

    public String toString()
    {
        return "(" + numerator + "," + denominator + ")";
    }

}
