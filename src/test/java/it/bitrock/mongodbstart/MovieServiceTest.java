package it.bitrock.mongodbstart;

import it.bitrock.mongodbstart.dto.MovieDTO;
import it.bitrock.mongodbstart.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class MovieServiceTest {

    @Test
    void findMovieByTitlePositiveTest(){
        Assertions.assertEquals(MovieService.findMovieByTitle("Intolerance: Love's Struggle Throughout the Ages").getId(),"573a1390f29313caabcd5c0f");
    }

    @Test
    void findMovieByTitleNegativeTest(){
        Assertions.assertEquals(MovieService.findMovieByTitle("Iaokdowkodd03j99duj398j3idm"),new MovieDTO());
    }

    @Test
    void findMovieByTitleExceptionTest(){
        Assertions.assertEquals(MovieService.findMovieByTitle(null),new MovieDTO());
    }

    @Test
    void findMovieByRatingNumReviewsPositiveTest(){
        Assertions.assertEquals(MovieService.findMovieByRatingNumReviews(3d,2000d).size(),5);
    }

    @Test
    void findMovieByRatingNumReviewsNegativeTest(){
        Assertions.assertEquals(MovieService.findMovieByRatingNumReviews(3d,2000000000d).size(),0);
    }
    @Test
    void findMovieByRatingNumReviewsExceptionTest(){
        Assertions.assertEquals(MovieService.findMovieByRatingNumReviews(null,2000000000d).size(),0);
        Assertions.assertEquals(MovieService.findMovieByRatingNumReviews(3d,null).size(),0);
        Assertions.assertEquals(MovieService.findMovieByRatingNumReviews(null,null).size(),0);
    }


    @Test
    void findAllMovieByCommentEmail(){
        MovieService.findAllMovieByCommentEmail("shawn_mccormick@fakegmail.com").iterator().forEachRemaining(movie-> System.out.println(movie));
        Assertions.assertEquals(MovieService.findAllMovieByCommentEmail("shawn_mccormick@fakegmail.com").size(),10);

    }


}
