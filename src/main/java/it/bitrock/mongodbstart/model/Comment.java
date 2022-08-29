package it.bitrock.mongodbstart.model;


import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@Document("comments")
public class Comment {

    @BsonId
    private ObjectId id;
    @BsonProperty("name")
    private String name;
    @BsonProperty("email")
    private String email;
    @BsonProperty("movie_id")
    private ObjectId movieId;
    @BsonProperty("date")
    private LocalDateTime date;
    @BsonProperty("text")
    private String text;


}
