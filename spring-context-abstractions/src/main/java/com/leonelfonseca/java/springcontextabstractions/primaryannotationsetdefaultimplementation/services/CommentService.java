package com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.services;

import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.proxies.CommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Spring creates a bean of this class and adds it to its context. */
@Component
public class CommentService {

  @Autowired private CommentRepository commentRepository;

  @Autowired private CommentNotificationProxy commentNotificationProxy;

  public void publishComment(Comment comment) {
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }
}
