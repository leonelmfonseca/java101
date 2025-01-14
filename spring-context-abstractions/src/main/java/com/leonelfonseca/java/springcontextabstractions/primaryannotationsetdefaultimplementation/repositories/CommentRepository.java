package com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.repositories;

import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);

}
