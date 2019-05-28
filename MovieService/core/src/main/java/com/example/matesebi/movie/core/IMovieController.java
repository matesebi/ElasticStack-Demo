package com.example.matesebi.movie.core;

import com.example.matesebi.movie.api.dto.CreateMovieRequest;
import com.example.matesebi.movie.api.dto.MovieResponse;
import com.example.matesebi.movie.api.dto.UpdateMovieRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RequestMapping
public interface IMovieController {

    @GetMapping("/api/movies")
    List<MovieResponse> getMovies();

    @PostMapping("/api/movies")
    MovieResponse createMovie(@RequestBody CreateMovieRequest movie);

    @GetMapping("/api/movies/{id}")
    MovieResponse getMovieById(@PathVariable("id") Long id);

    @PutMapping("/api/movies/{id}")
    MovieResponse updateMovie(@PathVariable("id") Long id, @RequestBody UpdateMovieRequest movie);

    @DeleteMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable("id") Long id);

    @GetMapping("/api/movies/find")
    List<MovieResponse> searchByYear(@RequestParam("year") Year year, @RequestParam("orderby") String orderBy);
}
