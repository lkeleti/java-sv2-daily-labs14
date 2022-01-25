package week14.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;

    @BeforeEach
    void init() {
        movieService = new MovieService();
        movieService.addMovie(new Movie("Jurassic park",127, Arrays.asList("Samuel L. Jackson","Laura Dern")));
        movieService.addMovie(new Movie("Jurassic world",124, Arrays.asList("Chris Pratt","Bryce Dallas Howard","Irrfan Khan")));
        movieService.addMovie(new Movie("Avengers: Endgame",181, Arrays.asList("Robert Downey Jr.","Chris Evans","Mark Ruffalo","Chris Pratt","Scarlett Johansson")));
    }

    @Test
    void getMoviesByActor() {
        List<Movie> result = movieService.getMoviesByActor("Chris Pratt");
        assertEquals(2, result.size());

        result = movieService.getMoviesByActor("Robert Downey Jr.");
        assertEquals(1, result.size());

        result = movieService.getMoviesByActor("Dwayne Johnson");
        assertEquals(0, result.size());
    }

    @Test
    void getLongestMovieLength() {
        assertEquals(181, movieService.getLongestMovieLength());
    }
}