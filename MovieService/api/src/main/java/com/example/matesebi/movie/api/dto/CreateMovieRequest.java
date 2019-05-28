package com.example.matesebi.movie.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest {

    private String title;
    private Year year;
    private String director;
    private List<String> actors;

}
