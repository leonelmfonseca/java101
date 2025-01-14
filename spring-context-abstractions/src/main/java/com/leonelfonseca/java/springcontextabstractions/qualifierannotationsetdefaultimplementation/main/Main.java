package com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.main;

import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.config.AbstractionsConfiguration;
import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.services.CommentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(AbstractionsConfiguration.class);

    // Creates an instance of comment to send as a parameter to the publish comment use case
    var comment = new Comment();
    comment.setAuthor("Bugs Bunny");
    comment.setText("That's all folks!");

    // Creates the instance of the service class and providing the dependencies
    var commentService = context.getBean(CommentService.class);

    commentService.publishComment(comment);
  }
}
