package it.bitrock.mongodbstart.service;


import it.bitrock.mongodbstart.dto.MovieDTO;
import it.bitrock.mongodbstart.dto.transformer.MovieTransformer;
import it.bitrock.mongodbstart.model.Movie;
import it.bitrock.mongodbstart.model.queryutils.MovieQuery;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MovieService {


    public static MovieDTO findMovieByTitle(String title) {
        Movie movie = MovieQuery.findMovieByTitle(title);
        if (movie != null) {
            return MovieTransformer.fromMovieToMovieDTO(movie);
        }
        return new MovieDTO();
    }

    public static List<MovieDTO> findFilmByGenres(List<String> generes) {
        if (generes != null) {
            List<Movie> movieListByGenres = MovieQuery
                    .findFilmByGenres(generes.stream().filter(genere->genere!=null).collect(Collectors.toList()));
            return movieListByGenres.stream().map(MovieTransformer::fromMovieToMovieDTO).toList();
        }
        return new ArrayList<>();
    }

    public static List<MovieDTO> findMovieByRatingNumReviews(Double rating, Double numReviews) {
        if (rating != null || numReviews!=null) {
        List<Movie> movieListByRatingNumReviews = MovieQuery.findMovieByRatingNumReviews(rating, numReviews);
            return movieListByRatingNumReviews.stream().map(MovieTransformer::fromMovieToMovieDTO).toList();
        }
        return new ArrayList<>();
    }

    public static List<MovieDTO> findAllMovieByCommentEmail(String email) {
       if (email != null){
           List<Movie> movieList = MovieQuery.findAllMovieByCommentEmail(email);
           if (!movieList.isEmpty()){
               return movieList.stream().map(MovieTransformer::fromMovieToMovieDTO).toList();
           }
       }
        return new ArrayList<>();
    }

    public static List<Document> findRatingFilmAndDirectors(String email) {
       return MovieQuery.findRatingFilmAndDirectors();
    }

    public static List<MovieDTO> sortMovieByRating() {
        return MovieQuery.sortMovieByRating()
                .stream().map(MovieTransformer::fromMovieToMovieDTO)
                .toList();

    }

}
