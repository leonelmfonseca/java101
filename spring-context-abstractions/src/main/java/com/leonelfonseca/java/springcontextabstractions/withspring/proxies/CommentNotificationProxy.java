package com.leonelfonseca.java.springcontextabstractions.withspring.proxies;

import com.leonelfonseca.java.springcontextabstractions.withspring.model.Comment;

/** Interfaces are abstract. We never use stereotype annotations on interfaces. */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}
