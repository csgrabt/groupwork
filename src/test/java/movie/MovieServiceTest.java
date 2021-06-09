package movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

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
        movieService.save(new Movie("HP4", 254, LocalDate.of(2003, 12, 12)));
        assertEquals(5, movieService.getMovies().size());
    }

    @Test
    void testFindNewest() {
        Movie movie = movieService.findNewest().get();
        assertEquals("HP4", movie.getName());
    }

    @Test
    void testFindMovieByNamePartListIsEmpty() {
        MovieService movieService1 = new MovieService();
        List<Movie> movieList = movieService1.findMovieByNamePart("");
        assertEquals(0, movieList.size());
    }


    @Test
    void testFindMovieByNamePart() {
        List<Movie> movieList = movieService.findMovieByNamePart("LLL");
        assertEquals(0, movieList.size());
    }

    @Test
    void testFindMovieByNamePartValid() {
        List<Movie> movieList = movieService.findMovieByNamePart("HP");
        assertEquals(4, movieList.size());
    }
    @Test
    void testFindMovieByNamePartValidNotCapital() {
        List<Movie> movieList = movieService.findMovieByNamePart("hp");
        assertEquals(0, movieList.size());
    }

}