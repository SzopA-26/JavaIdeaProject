package MovieComparator;

import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Avengers: Endgame", 181,9.0));
        movies.add(new Movie("Pokemon Detective Pikachu", 104, 0.0));
        movies.add(new Movie("Hellboy", 120, 5.4));
        movies.add(new Movie("Fighting with My Family", 108, 7.5));
        movies.add(new Movie("Okko's Inn", 94, 7.0));
        movies.add(new Movie("The Curse of the Weeping Woman", 93, 5.8));
        movies.add(new Movie("Five Feet Apart" , 116, 7.1)); movies.add(new Movie("The Queens Corgi", 85, 5.5)); movies.add(new Movie("More than Blue", 105, 5.6));

        // min -> max
        System.out.println("\n\n-------- sort by name --------");
        Collections.sort(movies, new MovieNameComparator());
        for (Movie m : movies){
            System.out.println(m); }

        // min -> max
        System.out.println("\n\n-------- sort by length --------");
        Collections.sort(movies, new MovieLengthComparator());
        for (Movie m : movies){
            System.out.println(m); }

        // max -> min
        System.out.println("\n\n-------- sort by rating score --------");
        Collections.sort(movies, new MovieRatingScoreComparator());
        for (Movie m : movies){
            System.out.println(m); }
    }
}
