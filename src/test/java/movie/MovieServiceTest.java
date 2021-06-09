package movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    MovieService movieService = new MovieService();

    Movie movie1 = new Movie("HP1", 251, LocalDate.of(2000, 12, 12));
    Movie movie2 = new Movie("HP2", 252, LocalDate.of(2001, 12, 12));
    Movie movie3 = new Movie("HP3", 253, LocalDate.of(2002, 12, 12));
    Movie movie4 = new Movie("HP4", 254, LocalDate.of(2003, 12, 12));

    @BeforeEach
    void setUp() {
        movieService.save(movie1);
        movieService.save(movie2);
        movieService.save(movie3);
        movieService.save(movie4);

    }

    @Test
    void saveTest() {

        movieService.save(new Movie());
        assertEquals(5, movieService.getMovies().size());
        assertEquals(null, movieService.getMovies().get(4).getName());

    }

    @Test
    void testFindNewest() {
        Movie movie = movieService.findNewest().get();

        assertEquals("HP4", movie.getName());
    }
}