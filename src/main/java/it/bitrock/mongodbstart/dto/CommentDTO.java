package it.bitrock.mongodbstart.dto;

import lombok.*;


import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CommentDTO {

    private String id;
    private String name;
    private String email;
    private String movieId;
    private LocalDateTime date;
    private String text;

    public CommentDTO(){

    }

    public CommentDTO(String id, String name, String email, String movieId, LocalDateTime date, String text) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.movieId = movieId;
        this.date = date;
        this.text = text;
    }

    public CommentDTO(String name, String email, String movieId, LocalDateTime date, String text) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.movieId = movieId;
        this.date = date;
        this.text = text;
    }
}
