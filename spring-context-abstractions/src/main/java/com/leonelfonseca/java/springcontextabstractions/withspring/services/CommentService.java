package com.leonelfonseca.java.springcontextabstractions.withspring.services;

import com.leonelfonseca.java.springcontextabstractions.withspring.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.withspring.proxies.CommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.withspring.repositories.CommentRepository;
import org.springframework.stereotype.Component;

/** Spring creates a bean of this class and adds it to its context. */
@Component
public class CommentService {

  private final CommentRepository commentRepository;

  private final CommentNotificationProxy commentNotificationProxy;

  /**
   * We would have to use @Autowired if the class had more than one constructor. Spring uses this
   * constructor to create the bean and injects references from its context in the parameters when
   * creating the instance.
   */
  public CommentService(
      CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  public void publishComment(Comment comment) {
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }
}
