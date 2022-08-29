package it.bitrock.mongodbstart;

import it.bitrock.mongodbstart.dto.CommentDTO;
import it.bitrock.mongodbstart.service.CommentService;
import it.bitrock.mongodbstart.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CommentServiceTest {

    @Test
    void findCommentByEmailPositiveTest(){
        Assertions.assertEquals(CommentService.findCommentByEmail("shawn_mccormick@fakegmail.com").getId(),"5a9427648b0beebeb6957ba5");
        Assertions.assertEquals(CommentService.findCommentByEmail("mercedes_tyler@fakegmail.com").getId(),"5a9427648b0beebeb69579e7");
    }

    @Test
    void findCommentByEmaiNegativeTest(){
        Assertions.assertEquals(CommentService.findCommentByEmail("ssasasasas"),new CommentDTO());
    }

    @Test
    void findCommentByEmaiExeptionTest(){
        Assertions.assertEquals(CommentService.findCommentByEmail(null),new CommentDTO());
    }

    @Test
    void findCommentByDatePositiveTest(){
        Assertions.assertEquals(CommentService.findCommentByDate("01-01-2000").size(),50);
    }

    @Test
    void findCommentByDateNegativeTest(){
        Assertions.assertEquals(CommentService.findCommentByDate("01-01-20asdwd3d32d300").size(),0);
    }

    @Test
    void findCommentByDateExceptionTest(){
        Assertions.assertEquals(CommentService.findCommentByDate(null).size(),0);
    }

    @Test
    void findFilmByGenresPositiveTest(){
        Assertions.assertEquals(MovieService.findFilmByGenres(Arrays.asList("Drama" ,"History", "Romance")).size(),75);
    }

    @Test
    void findFilmByGenresNegativeTest(){
        Assertions.assertEquals(MovieService.findFilmByGenres(Arrays.asList("DramassdsdefeRomance")).size(),0);
    }

    @Test
    void findFilmByGenresExceptionTest(){
        List<String> generes = new ArrayList<>();
        generes.add(null);
        generes.add(null);
        Assertions.assertEquals(MovieService.findFilmByGenres(null).size(),0);
        Assertions.assertEquals(MovieService.findFilmByGenres(Arrays.asList()).size(),0);
        Assertions.assertEquals(MovieService.findFilmByGenres(generes).size(),0);
    }


}
