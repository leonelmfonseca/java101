package com.leonelfonseca.java.springcontextabstractions.withoutspring.proxies;

import com.leonelfonseca.java.springcontextabstractions.withoutspring.model.Comment;

/** Interfaces are abstract. We never use stereotype annotations on interfaces. */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}
