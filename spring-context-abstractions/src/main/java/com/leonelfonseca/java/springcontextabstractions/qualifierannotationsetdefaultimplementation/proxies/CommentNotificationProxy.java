package com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.proxies;

import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.model.Comment;

/** Interfaces are abstract. We never use stereotype annotations on interfaces. */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}
