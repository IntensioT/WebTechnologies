
import org.intensio.DAO.DAOFactory;
import org.intensio.DAO.MovieDAO;
import org.intensio.DAO.exception.DatabaseQueryException;
import org.intensio.beans.Movie;
import org.intensio.service.exception.ServiceException;
import org.intensio.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class MovieServiceImplTest {
    @Mock
    private MovieDAO movieDAO;

    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        movieService = new MovieServiceImpl();
    }

    @Test
    void testGetMovies() throws ServiceException, DatabaseQueryException {
        // Mock data
        List<Movie> movies = new ArrayList<>();
        movies.add(createMovie(1, "Movie 1", "Author 1"));
        movies.add(createMovie(2, "Movie 2", "Author 2"));

        // Mock behavior of movieDAO
        when(movieDAO.getMovies()).thenReturn(movies);

        // Call the method
        List<Movie> result = movieService.getMovies(0);

        // Verify the result
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Movie 1", result.get(0).getName());
        Assertions.assertEquals("Author 1", result.get(0).getAuthor());
        Assertions.assertEquals("Movie 2", result.get(1).getName());
        Assertions.assertEquals("Author 2", result.get(1).getAuthor());

        // Verify that the movieDAO method was called
        verify(movieDAO, times(1)).getMovies();
    }

    @Test
    void testGetMovieByName() throws ServiceException, DatabaseQueryException {
        // Mock data
        String name = "Movie 1";
        Movie movie = createMovie(1, name, "Author 1");

        // Mock behavior of movieDAO
        when(movieDAO.getMovieByName(name)).thenReturn(Optional.of(movie));

        // Call the method
        Optional<Movie> result = movieService.getMovieByName(name);

        // Verify the result
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(movie, result.get());

        // Verify that the movieDAO method was called
        verify(movieDAO, times(1)).getMovieByName(name);
    }

    @Test
    void testGetMovieById() throws ServiceException, DatabaseQueryException {
        // Mock data
        int id = 1;
        Movie movie = createMovie(id, "Movie 1", "Author 1");

        // Mock behavior of movieDAO
        when(movieDAO.getMovieById(id)).thenReturn(Optional.of(movie));

        // Call the method
        Optional<Movie> result = movieService.getMovieById(id);

        // Verify the result
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(movie, result.get());

        // Verify that the movieDAO method was called
        verify(movieDAO, times(1)).getMovieById(id);
    }

    @Test
    void testGetPageCount() throws ServiceException, DatabaseQueryException {
        // Mock data
        int movieCount = 10;
        List<Movie> movies = new ArrayList<>();
        for (int i = 1; i <= movieCount; i++) {
            movies.add(createMovie(i, "Movie " + i, "Author " + i));
        }

        // Mock behavior of movieDAO
        when(movieDAO.getMovies()).thenReturn(movies);

        // Call the method
        int result = movieService.getPageCount();

        // Verify the result
        Assertions.assertEquals(3, result);

        // Verify that the movieDAO method was called
        verify(movieDAO, times(1)).getMovies();
    }

    private Movie createMovie(int id, String name, String author) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setName(name);
        movie.setAuthor(author);
        return movie;
    }
}