package it.bitrock.mongodbstart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class Tomatoes {

   private Viewer viewer;
   private LocalDateTime lastUpdated;

}
