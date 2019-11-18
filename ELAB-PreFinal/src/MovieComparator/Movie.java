package MovieComparator;

public class Movie {
    private String name;
    private int length;
    private double ratingScore;

    public Movie(String name, int length, double ratingScore) {
        this.name = name;
        this.length = length;
        this.ratingScore = ratingScore;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public double getRatingScore() {
        return ratingScore;
    }

    public String toString() {
        return name + " : " + length + " minutes : rating " + ratingScore + "/10";
    }
}