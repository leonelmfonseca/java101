package com.leonelfonseca.java.springcontextabstractions.withspring.repositories;

import com.leonelfonseca.java.springcontextabstractions.withspring.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);

}
