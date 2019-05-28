package com.example.matesebi.movie.core;

import com.example.matesebi.movie.api.dto.CreateMovieRequest;
import com.example.matesebi.movie.api.dto.MovieResponse;
import com.example.matesebi.movie.api.dto.UpdateMovieRequest;
import com.example.matesebi.movie.core.messages.MovieMessage;
import com.example.matesebi.movie.core.messages.MovieResult;
import com.example.matesebi.movie.core.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.time.Year;
import java.util.List;

import static com.example.matesebi.movie.core.util.MapperUtil.*;

@Slf4j
@RestController
public class MovieController implements IMovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    private ResponseEntity<?> entityNotFound(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getLocalizedMessage());
    }

    @Override
    public List<MovieResponse> getMovies() {
        List<MovieResult> movieResults = this.movieService.getAll();

        return mapMovieResultsToMovieResponses(movieResults);
    }

    @Override
    public MovieResponse createMovie(CreateMovieRequest movie) {
        MovieMessage movieMessage = mapCreateMovieRequestToMovieMessage(movie);

        MovieResult movieResult = this.movieService.save(movieMessage);

        return mapMovieResultToMovieResponse(movieResult);
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        MovieResult movieResult = this.movieService.findById(id);

        return mapMovieResultToMovieResponse(movieResult);
    }

    @Override
    public MovieResponse updateMovie(Long id, UpdateMovieRequest movie) {
        MovieMessage movieMessage = mapUpdateMovieRequestToMovieMessage(movie);

        return mapMovieResultToMovieResponse(this.movieService.update(id, movieMessage));
    }

    @Override
    public void deleteMovie(Long id) {
        this.movieService.deleteById(id);
    }

    @Override
    public List<MovieResponse> searchByYear(Year year, String orderBy) {
        List<MovieResult> movieResults = this.movieService.find(year, orderBy);
        return mapMovieResultsToMovieResponses(movieResults);
    }
}
