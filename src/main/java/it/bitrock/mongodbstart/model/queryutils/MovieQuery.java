package it.bitrock.mongodbstart.model.queryutils;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import it.bitrock.mongodbstart.config.MongoDBConfiguration;
import it.bitrock.mongodbstart.model.Movie;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.aggregation.ObjectOperators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Aggregates.replaceRoot;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Sorts.descending;

public class MovieQuery {
    private static MongoDatabase mongoDatabase  = MongoDBConfiguration
            .getInstance()
            .mongoDatabase();


    public static Movie findMovieByTitle(String title){
       return mongoDatabase.getCollection("movies",Movie.class).find(new Document("title",title)).iterator().tryNext();
    }

    public static List<Movie> findFilmByGenres(List<String> genres){
        return mongoDatabase.getCollection("movies",Movie.class).find(all("genres",genres))
                .into(new ArrayList<>());
    }


    public static List<Movie> findMovieByRatingNumReviews(Double rating,Double numReviews){
        return mongoDatabase.getCollection("movies",Movie.class).find(and(
                        gte("tomatoes.viewer.rating",rating),
                        gt("tomatoes.viewer.numReviews",numReviews)
                )).limit(5)
                .into(new ArrayList<>());
    }

    public static List<Movie> sortMovieByRating(){
        return mongoDatabase.getCollection("movies",Movie.class).find()
                .sort(descending("tomatoes.viewer.rating"))
                .limit(20)
                .into(new ArrayList<>());
    }


    public static List<Movie> findAllMovieByCommentEmail(String email){
        return mongoDatabase.getCollection("comments", Movie.class).aggregate(
                Arrays.asList(new Document("$match",
                                new Document("email",email)),
                        new Document("$limit", 10L),
                        new Document("$project",
                                new Document("movie_id", 1L)
                                        .append("_id", 0L)),
                        new Document("$lookup",
                                new Document("from", "movies")
                                        .append("localField", "movie_id")
                                        .append("foreignField", "_id")
                                        .append("as", "movies")),
                        new Document("$replaceRoot",
                                new Document("newRoot",
                                        new Document("$mergeObjects",
                                                Arrays.asList(new Document("$arrayElemAt", Arrays.asList("$movies", 0L)), "$$ROOT")))),
                        new Document("$project",
                                new Document("movies", 0L)
                                        .append("movie_id", 0L)))).into(new ArrayList<>());
    }


    public static List<Document> findRatingFilmAndDirectors(){
        return mongoDatabase.getCollection("movies").aggregate(Arrays.asList(new Document("$facet",
                new Document("votazione_per_film", Arrays.asList(new Document("$limit", 50L),
                        new Document("$match",
                                new Document("imdb.rating",
                                        new Document("$lte", 10L))),
                        new Document("$bucket",
                                new Document("groupBy", "$imdb.rating")
                                        .append("boundaries", Arrays.asList(0L, 6L, 8L, 10L))
                                        .append("default", "not voted")
                                        .append("output",
                                                new Document("count",
                                                        new Document("$sum", 1L))
                                                        .append("title",
                                                                new Document("$push", "$title"))))))
                        .append("film_per_director", Arrays.asList(new Document("$limit", 50L),
                                new Document("$unwind",
                                        new Document("path", "$directors")
                                                .append("preserveNullAndEmptyArrays", false)),
                                new Document("$group",
                                        new Document("_id", "$directors")
                                                .append("movies",
                                                        new Document("$push", "$title")))))))).into(new ArrayList<>());
    }


    public static Movie findMovieByComment(String id){
        List<Bson> pipelineMatch = Arrays.asList(
                match(Filters.eq("_id",new ObjectId(id)))
                ,lookup("movies", "movie_id", "_id", "movies")
                ,project(new Document("movies", 1L).append("_id", 0L))
                ,replaceRoot(ObjectOperators.MergeObjects.mergeValuesOf(ArrayOperators.ArrayElemAt
                        .arrayOf("$movies").elementAt(0)).mergeWith(Aggregation.ROOT))


        );
        return mongoDatabase.getCollection("movies",Movie.class).aggregate(pipelineMatch).first();
    }

    public static List<Document> findMovieTitleForCountries(){
        return mongoDatabase.getCollection("movies").aggregate(
                Arrays.asList(new Document("$unwind",
                                new Document("path", "$countries")
                                        .append("preserveNullAndEmptyArrays", false)),
                        new Document("$group",
                                new Document("_id", "$countries")
                                        .append("count_id",
                                                new Document("$sum", 1L))
                                        .append("movies",
                                                new Document("$push", "$title"))))).into(new ArrayList<>());
    }



}
