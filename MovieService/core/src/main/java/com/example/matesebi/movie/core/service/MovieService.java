package com.example.matesebi.movie.core.service;

import com.example.matesebi.movie.core.domain.Movie;
import com.example.matesebi.movie.core.messages.MovieMessage;
import com.example.matesebi.movie.core.messages.MovieResult;
import com.example.matesebi.movie.core.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Year;
import java.util.List;
import java.util.Optional;

import static com.example.matesebi.movie.core.util.MapperUtil.*;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResult> getAll() {
        return mapMoviesToMovieResults(this.movieRepository.findAll());
    }

    public MovieResult save(MovieMessage movieMessage) {
        Movie movie = mapMovieMessageToMovie(movieMessage);
        return mapMovieToMovieResult(this.movieRepository.save(movie));
    }

    public MovieResult findById(Long id) {
        Optional<Movie> movieOptional = this.movieRepository.findById(id);
        Movie movie = movieOptional.orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));

        return mapMovieToMovieResult(movie);
    }

    public MovieResult update(Long id, MovieMessage movieMessage) {
        Movie movie = mapMovieMessageToMovie(movieMessage);
        movie.setId(id);
        return mapMovieToMovieResult(this.movieRepository.save(movie));
    }

    public void deleteById(Long id) {
        this.movieRepository.deleteById(id);
    }

    public List<MovieResult> find(Year year, String orderBy) {

        if(orderBy.equals("title")){
            return mapMoviesToMovieResults(this.movieRepository.findAllByYearOrderByTitle(year));
        }else {
            return mapMoviesToMovieResults(this.movieRepository.findAllByYearOrderByDirector(year));
        }
    }
}
