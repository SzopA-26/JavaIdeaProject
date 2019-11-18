package MovieComparator;

import java.util.Comparator;

public class MovieLengthComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getLength()-o2.getLength();
    }
}
