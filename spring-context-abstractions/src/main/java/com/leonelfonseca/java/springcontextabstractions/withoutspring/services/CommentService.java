package com.leonelfonseca.java.springcontextabstractions.withoutspring.services;

import com.leonelfonseca.java.springcontextabstractions.withoutspring.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.withoutspring.proxies.CommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.withoutspring.repositories.CommentRepository;

public class CommentService {

  /** We define the two dependencies as attributes of the class */
  private final CommentRepository commentRepository;

  private final CommentNotificationProxy commentNotificationProxy;

  /**
   * SOLID(D) Dependency Inversion Principle (DIP) High-level modules should not depend on low-level
   * modules. Both should depend on abstractions. Abstractions should not depend on details. Details
   * should depend on abstractions. Use dependency injection to pass the required dependencies to a
   * class, rather than creating dependencies within the class.
   */
  public CommentService(
      CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  /**
   * We implement the use case that delegates the “store comment” and “send notification”
   * responsibilities to the dependencies.
   */
  public void publishComment(Comment comment) {
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }
}
