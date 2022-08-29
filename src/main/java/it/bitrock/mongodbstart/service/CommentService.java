package it.bitrock.mongodbstart.service;

import it.bitrock.mongodbstart.dto.CommentDTO;
import it.bitrock.mongodbstart.dto.transformer.CommentTransformer;
import it.bitrock.mongodbstart.model.Comment;
import it.bitrock.mongodbstart.model.queryutils.CommentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CommentService {

    public static CommentDTO findCommentByEmail(String email) {
        if (email != null) {
            Comment comment = CommentQuery.findCommentByEmail(email);
            if (comment != null) {
                return CommentTransformer.fromCommentToCommentDTO(comment);
            }
        }
        return new CommentDTO();
    }

    public static List<CommentDTO> findCommentByDate(String date) {
        List<Comment> commentList = CommentQuery.findCommentByDate(date);
        if (commentList != null) {
            return commentList.stream().map(CommentTransformer::fromCommentToCommentDTO).toList();
        }
        return new ArrayList<>();
    }



    public static boolean insertComment(CommentDTO commentDTO)  {
     if(commentDTO!=null) {
       try {
           CommentQuery.insertComment(commentDTO);
           return true;
       }catch (RuntimeException rn){
           throw new RuntimeException("-----------");
       }
     }
     else return false;
    }
}
