package com.example.matesebi.movie.api.dto;

import lombok.*;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    private Long id;
    private String title;
    private Year year;
    private String director;
    private List<String> actors;

}
