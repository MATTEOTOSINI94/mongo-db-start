package it.bitrock.mongodbstart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("session")
public class Session {

    @BsonId
    private ObjectId id;
    @BsonProperty("user_id")
    private ObjectId userId;
    @BsonProperty("jwt")
    private String jwt;

}
