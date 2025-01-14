package com.leonelfonseca.java.springcontextabstractions.withspring.repositories;

import com.leonelfonseca.java.springcontextabstractions.withspring.model.Comment;
import org.springframework.stereotype.Component;

/**
 * Marking the class with @Component instructs Spring to instantiate the class and add an instance
 * as a bean in its context.
 */
@Component
public class DBCommentRepository implements CommentRepository {

  @Override
  public void storeComment(Comment comment) {
    System.out.println("Storing comment: " + comment.getText());
  }
}
