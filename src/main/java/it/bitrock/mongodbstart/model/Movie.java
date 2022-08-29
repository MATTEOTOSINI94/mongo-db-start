package it.bitrock.mongodbstart.model;


import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@Getter
@Setter
@Document("movies")
public class Movie {


    @BsonId
    private ObjectId id;
    @BsonProperty("plot")
    private String plot;
    @BsonProperty("fullplot")
    private String fullPlot;
    @BsonProperty("genres")
    private List<String> genres;
    @BsonProperty("title")
    private String title;
    @BsonProperty("runtime")
    private Integer runTime;
    @BsonProperty("cast")
    private List<String> cast;
    @BsonProperty("num_mflix_comments")
    private Integer numMflixComments;
    @BsonProperty("countries")
    private List<String> countries;
    @BsonProperty("released")
    private LocalDateTime released;
    @BsonProperty("directors")
    private List<String> directors;
    @BsonProperty("rated")
    private String rated;
    @BsonProperty("awards")
    private Awards awards;
    @BsonProperty("lastupdated")
    private String lastUpdated;
    @BsonProperty("year")
    private Long year;
    @BsonProperty("imdb")
    private Imdb imdb;
    @BsonProperty("tomatoes")
    private Tomatoes tomatoes;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", plot='" + plot + '\'' +
                ", fullPlot='" + fullPlot + '\'' +
                ", genres=" + genres +
                ", title='" + title + '\'' +
                ", runTime=" + runTime +
                ", cast=" + cast +
                ", numMflixComments=" + numMflixComments +
                ", countries=" + countries +
                ", released=" + released +
                ", directors=" + directors +
                ", rated='" + rated + '\'' +
                ", awards=" + awards +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", year=" + year +
                ", imdb=" + imdb +
                ", tomatoes=" + tomatoes +
                '}';
    }
}
