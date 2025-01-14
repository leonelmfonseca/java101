package com.leonelfonseca.java.springcontextabstractions.withspring.main;

import com.leonelfonseca.java.springcontextabstractions.withspring.model.Comment;
import com.leonelfonseca.java.springcontextabstractions.withspring.proxies.EmailCommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.withspring.repositories.DBCommentRepository;
import com.leonelfonseca.java.springcontextabstractions.withspring.services.CommentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {


  public static void main(String[] args) {

    var commentRepository = new DBCommentRepository();

    var commentCommentNotificationProxy =
        new EmailCommentNotificationProxy(); // Creates the instance for the dependencies

    // Creates the instance of the service class and providing the dependencies
    var commentService = new CommentService(commentRepository, commentCommentNotificationProxy);

    // Creates an instance of comment to send as a parameter to the publish comment use case
    var comment = new Comment();
    comment.setAuthor("Bugs Bunny");
    comment.setText("That's all folks!");

    commentService.publishComment(comment); // Calls the publish comment use case
  }

  /**
   * When/if you want to change repos or proxies, just create a new class, implementing the desired
   * interface and override correspondent methods. Then, you just have to create the objects that implement
   * desired functionality, and pass it to service.
   *
   *
   *   ├── main
   *   │      └── Main.java
   *   ├── model
   *   │      └── Comment.java
   *   ├── proxies
   *   │      ├── CommentNotificationProxy.java
   *   │      └── EmailCommentNotificationProxy.java
   *   ├── repositories
   *   │      ├── CommentRepository.java
   *   │      └── DBCommentRepository.java
   *   └── services
   *          └── CommentService.java
   */

}
