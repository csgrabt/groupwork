package movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    MovieService movieService = new MovieService();

    @Test
    void saveTest() {
        movieService.save(new Movie());
        assertEquals(1, movieService.getMovies().size());
    }


}