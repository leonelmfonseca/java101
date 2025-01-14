package com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.proxies;

import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.model.Comment;

/** Interfaces are abstract. We never use stereotype annotations on interfaces. */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}
