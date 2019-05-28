package com.example.matesebi.movie.api;


import com.example.matesebi.movie.api.dto.CreateMovieRequest;
import com.example.matesebi.movie.api.dto.MovieResponse;
import com.example.matesebi.movie.api.dto.UpdateMovieRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@FeignClient(name = "movie", url = "${movie.url}/api/movies")
public interface MovieClient {

    @GetMapping("/")
    List<MovieResponse> getMovies();

    @PostMapping("/")
    MovieResponse createMovie(@RequestBody CreateMovieRequest movie);

    @GetMapping("/{id}")
    MovieResponse getMovieById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    MovieResponse updateMovie(@PathVariable("id") Long id, @RequestBody UpdateMovieRequest movie);

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable("id") Long id);

    @GetMapping("/find")
    List<MovieResponse> searchByYear(@RequestParam("year") Year year, @RequestParam("orderby") String orderBy);
}
