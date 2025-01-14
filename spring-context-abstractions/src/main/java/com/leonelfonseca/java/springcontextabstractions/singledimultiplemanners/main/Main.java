package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.main;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.proxies.EmailCommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories.DBCommentRepository;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.services.CommentService;

public class Main {

  public static void main(String[] args) {

    var commentRepository = new DBCommentRepository(); // Creates the instance for the dependencies

    var commentCommentNotificationProxy =
        new EmailCommentNotificationProxy(); // Creates the instance for the dependencies

    // Creates the instance of the service class and providing the dependencies
    var commentService = new CommentService(commentRepository, commentCommentNotificationProxy);

    // Creates an instance of comment to send as a parameter to the publishing comment use case
    var comment = new Comment();
    comment.setAuthor("Bugs Bunny");
    comment.setText("That's all folks!");

    commentService.publishComment(comment); // Calls the publishing comment use case
  }

  /*
   When/if you want to change repos or proxies, just create a new class, implementing the desired
   interface and override correspondent methods. Then, you just have to create the objects that implement
   desired functionality, and pass it to service.


     ├── main
     │      └── Main.java
     ├── model
     │      └── Comment.java
     ├── proxies
     │      ├── CommentNotificationProxy.java
     │      └── EmailCommentNotificationProxy.java
     ├── repositories
     │      ├── CommentRepository.java
     │      └── DBCommentRepository.java
     └── services
            └── CommentService.java
  */

}
