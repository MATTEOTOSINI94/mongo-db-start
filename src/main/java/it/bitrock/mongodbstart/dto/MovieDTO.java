package it.bitrock.mongodbstart.dto;

import it.bitrock.mongodbstart.model.Imdb;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MovieDTO {

    private String id;

    private String plot;

    private String fullPlot;

    private List<String> genres;

    private String title;

    private Integer runTime;

    private List<String> cast;

    private Integer numMflixComments;

    private List<String> countries;

    private LocalDateTime released;

    private List<String> directors;

    private String rated;

    private AwardsDTO awards;

    private String lastUpdated;

    private Long year;

    private Imdb imdb;

    private TomatoesDTO tomatoes;
}
