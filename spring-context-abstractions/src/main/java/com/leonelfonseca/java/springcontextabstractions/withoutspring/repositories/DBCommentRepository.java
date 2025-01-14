package com.leonelfonseca.java.springcontextabstractions.withoutspring.repositories;

import com.leonelfonseca.java.springcontextabstractions.withoutspring.model.Comment;

public class DBCommentRepository implements CommentRepository {

  /**
   * The interface only gives the what the CommentService object needs for implementing the use
   * case: store a comment.
   * When you define an object that implements this contract, it needs to
   * override the "storeComment(Comment comment)" method to define the how.
   *
   * @param comment
   */
  @Override
  public void storeComment(Comment comment) {
    System.out.println("Storing comment: " + comment.getText());
  }
}
