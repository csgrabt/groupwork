package movie;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        if (movie == null || movie.getReleaseDate() == null) {
            throw new IllegalArgumentException("Cannot be null!");
        }
        movies.add(movie);
    }

    public List<Movie> findMovieByNamePart(String part) {
        return movies
                .stream()
                .filter(movie -> movie.getName().contains(part))
                .collect(Collectors.toList());
    }

    public Optional<Movie> findNewest() {
        return movies
                .stream()
                .max(Comparator.comparing(Movie::getReleaseDate));
    }

    public Integer totalLength() {
        return movies
                .stream()
                .reduce(0, (a, b) -> a + b.getLength(), (x, y) -> x + y);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public Map<LocalDate, Integer> countingFilmsByReleaseDate() {
        return movies
                .stream()
                .collect(Collectors.toMap(m -> m.getReleaseDate(), n -> 1, Integer::sum));

    }


}
