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
@Document("user")
public class User {
    @BsonId
    private ObjectId id;

    @BsonProperty("name")
    private String name;

    @BsonProperty("email")
    private String email;


}
