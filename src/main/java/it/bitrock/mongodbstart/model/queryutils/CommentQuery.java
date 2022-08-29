package it.bitrock.mongodbstart.model.queryutils;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import it.bitrock.mongodbstart.config.MongoDBConfiguration;
import it.bitrock.mongodbstart.dto.CommentDTO;
import it.bitrock.mongodbstart.dto.transformer.CommentTransformer;
import it.bitrock.mongodbstart.model.Comment;

import it.bitrock.mongodbstart.service.ServiceUtils;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class CommentQuery {

    private static MongoDatabase mongoDatabase  = MongoDBConfiguration
            .getInstance()
            .mongoDatabase();

    public static Comment findCommentByEmail(String email){
        return mongoDatabase.getCollection("comments",Comment.class).find(new Document("email",email)).first();
    }

    public static void insertComment(CommentDTO commentDTO){
        mongoDatabase.getCollection("comments",Comment.class).insertOne(CommentTransformer.fromCommentDTOToComment(commentDTO));
    }

    public static List<Comment> findCommentByDate(String date){
        if(ServiceUtils.isValidDate(date)){
        return mongoDatabase.getCollection("comments",Comment.class)
                .find(Filters.gte("date",ServiceUtils.transformStringToLocalDateTime(date)))
                .limit(50).into(new ArrayList<>());
        }return null;
    }


}
