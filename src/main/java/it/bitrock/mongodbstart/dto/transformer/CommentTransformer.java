package it.bitrock.mongodbstart.dto.transformer;

import it.bitrock.mongodbstart.dto.CommentDTO;
import it.bitrock.mongodbstart.model.Comment;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class CommentTransformer {

    private CommentTransformer(){

    }

    public static CommentDTO fromCommentToCommentDTO(Comment comment){
        return new CommentDTO(comment.getId().toHexString(),
                comment.getName(),
                comment.getEmail(),
                comment.getMovieId().toHexString(),
                comment.getDate()
                ,comment.getText());
    }

    public static Comment fromCommentDTOToComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setMovieId(new ObjectId(commentDTO.getMovieId()));
        comment.setDate(commentDTO.getDate());
        comment.setText(commentDTO.getText());
        return comment;
    }
}
