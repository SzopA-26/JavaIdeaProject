//elab-source:PositiveMixedFraction.java

public class PositiveMixedFraction {
    private long wholeNumber;
    private long nominator;
    private long denominator;

    public PositiveMixedFraction() {
        this.wholeNumber = 0;
        this.nominator = 0;
        this.denominator = 1;
    }

    public PositiveMixedFraction(long wholeNumber, long nominator, long denominator) {
        if (wholeNumber < 0 || nominator < 0 || denominator <= 0) {
            throw new RuntimeException();
        }
        while (nominator > denominator) {
            wholeNumber += 1;
            nominator -= denominator;
        } if (nominator == denominator) {
            wholeNumber += 1;
            nominator = 0;
            denominator = 1;
        } this.wholeNumber = wholeNumber;
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public long getWholeNumber() {
        return wholeNumber;
    }

    public long getNominator() {
        return nominator;
    }

    public long getDenominator() {
        return denominator;
    }
}