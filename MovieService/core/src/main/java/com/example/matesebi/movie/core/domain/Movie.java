package com.example.matesebi.movie.core.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Year year;
    private String director;

    @ElementCollection
    private List<String> actors;
}
