package MovieComparator;

import java.util.Comparator;

public class MovieRatingScoreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getRatingScore(), o1.getRatingScore());
    }
}
