package week14.day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMoviesByActor(String actor) {
        return movies.stream()
                .filter(m->m.getActors().contains(actor))
                .collect(Collectors.toList());
    }

    public int getLongestMovieLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max()
                .orElseThrow(()-> new IllegalStateException("List is empty!"));
    }
}
