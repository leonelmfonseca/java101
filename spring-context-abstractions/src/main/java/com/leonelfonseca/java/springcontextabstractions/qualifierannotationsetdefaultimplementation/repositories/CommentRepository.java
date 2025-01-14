package com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.repositories;

import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);

}
