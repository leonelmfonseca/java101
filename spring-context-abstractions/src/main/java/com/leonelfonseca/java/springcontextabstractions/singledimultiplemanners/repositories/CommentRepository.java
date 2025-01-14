package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);

}
