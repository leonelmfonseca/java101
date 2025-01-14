package com.leonelfonseca.java.springcontextabstractions.withoutspring.repositories;

import com.leonelfonseca.java.springcontextabstractions.withoutspring.model.Comment;

/** Interfaces are abstract. We never use stereotype annotations on interfaces. */
public interface CommentRepository {

  void storeComment(Comment comment);
}
