package com.example.matesebi.movie.core.repository;

import com.example.matesebi.movie.core.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import java.time.Year;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAllByYearOrderByTitle(Year year);

    List<Movie> findAllByYearOrderByDirector(Year year);
}
