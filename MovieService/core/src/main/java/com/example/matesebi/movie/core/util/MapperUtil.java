package com.example.matesebi.movie.core.util;

import com.example.matesebi.movie.api.dto.CreateMovieRequest;
import com.example.matesebi.movie.api.dto.MovieResponse;
import com.example.matesebi.movie.api.dto.UpdateMovieRequest;
import com.example.matesebi.movie.core.domain.Movie;
import com.example.matesebi.movie.core.messages.MovieMessage;
import com.example.matesebi.movie.core.messages.MovieResult;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MapperUtil {

    private MapperUtil() {
        throw new IllegalStateException("Constructor of util class called");
    }

    public static MovieResult mapMovieToMovieResult(Movie movie){
        return MovieResult.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .year(movie.getYear())
                .director(movie.getDirector())
                .actors(movie.getActors())
                .build();
    }

    public static List<MovieResult> mapMoviesToMovieResults(Iterable<Movie> movies) {
        return StreamSupport.stream(movies.spliterator(), false)
                .map(MapperUtil::mapMovieToMovieResult)
                .collect(Collectors.toList());
    }

    public static MovieResponse mapMovieResultToMovieResponse(MovieResult movieResult){
        return MovieResponse.builder()
                .id(movieResult.getId())
                .title(movieResult.getTitle())
                .year(movieResult.getYear())
                .director(movieResult.getDirector())
                .actors(movieResult.getActors())
                .build();
    }

    public static List<MovieResponse> mapMovieResultsToMovieResponses(Collection<MovieResult> movieResults){
        return movieResults.stream()
                .map(MapperUtil::mapMovieResultToMovieResponse)
                .collect(Collectors.toList());
    }

    public static MovieMessage mapCreateMovieRequestToMovieMessage(CreateMovieRequest movie){
        return MovieMessage.builder()
                .title(movie.getTitle())
                .year(movie.getYear())
                .director(movie.getDirector())
                .actors(movie.getActors())
                .build();
    }

    public static MovieMessage mapUpdateMovieRequestToMovieMessage(UpdateMovieRequest request){
        return MovieMessage.builder()
                .title(request.getTitle())
                .year(request.getYear())
                .director(request.getDirector())
                .actors(request.getActors())
                .build();
    }

    public static Movie mapMovieMessageToMovie(MovieMessage movieMessage){
        return Movie.builder()
                .title(movieMessage.getTitle())
                .year(movieMessage.getYear())
                .director(movieMessage.getDirector())
                .actors(movieMessage.getActors())
                .build();
    }
}
