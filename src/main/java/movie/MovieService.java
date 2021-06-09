package movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        if (movie == null || movie.getReleaseDate()==null) {
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

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }
}
