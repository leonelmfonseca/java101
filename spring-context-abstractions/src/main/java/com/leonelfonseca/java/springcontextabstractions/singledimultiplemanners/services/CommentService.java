package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.services;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.proxies.CommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories.CommentRepository;

public class CommentService {

  private final CommentRepository commentRepository;

  private final CommentNotificationProxy commentNotificationProxy;

  private String commentServiceName = "Default Comment Service";

  /*
   We would have to use @Autowired if the class had more than one constructor.
   Spring uses this constructor to create the bean and injects references from its context in the parameters when
   creating the instance.

   When a class has multiple constructors, Spring needs a way to determine which constructor
   to use for dependency injection.
   In such case, you use the @Autowired annotation to explicitly indicate which constructor
   Spring should use to create the bean.

   In Spring, you cannot use @Autowired on multiple constructors in the same class.
   Spring needs a single point of entry for dependency injection when creating a bean.
   If you try to annotate multiple constructors with @Autowired, it will lead to ambiguity and an error
   because Spring won't know which constructor to use.
  */

  public CommentService(
      CommentRepository commentRepository,
      CommentNotificationProxy commentNotificationProxy,
      String commentServiceName) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
    this.commentServiceName = "Defined as an argument " + commentServiceName;
  }

  public CommentService(
      CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
    this.commentServiceName = "this is the 2 param method call";
  }

  public void publishComment(Comment comment) {
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }
}
