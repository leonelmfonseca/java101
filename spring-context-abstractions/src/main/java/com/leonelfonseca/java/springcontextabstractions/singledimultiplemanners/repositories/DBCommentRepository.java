package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {

  @Override
  public void storeComment(Comment comment) {
    System.out.println("Storing comment: " + comment.getText());
  }
}
