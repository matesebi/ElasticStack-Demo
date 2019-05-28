package com.example.matesebi.movie.core.messages;

import lombok.*;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieMessage {

    private String title;
    private Year year;
    private String director;
    private List<String> actors;

}
