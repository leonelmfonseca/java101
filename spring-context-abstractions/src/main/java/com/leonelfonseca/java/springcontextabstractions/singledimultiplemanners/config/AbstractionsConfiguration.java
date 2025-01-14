package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.config;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.proxies.CommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.proxies.EmailCommentNotificationProxy;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories.CommentRepository;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.repositories.DBCommentRepository;
import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

/*
Because we don’t use stereotype annotations(@Component), we no longer need to use the @ComponentScan annotation.
If you explicitly define a bean using the @Bean annotation in a @Configuration class,
it takes precedence and ensures that Spring will use the bean definition from the configuration class.
Whether the class has a @Component annotation becomes irrelevant in this context.
 */

public class AbstractionsConfiguration {

  @Bean
  String defaultCommentServiceName() {
    return "this came from configuration class";
  }

  /*We use parameters of the @Bean method (which are now defined with
  the interface type above) to instruct Spring to provide references for beans
  from its context(beans with @Component annotation), compatible with the type of the parameters.*/
  @Bean
  public CommentService commentService(
      CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
    return new CommentService(commentRepository, commentNotificationProxy);
  }

  @Bean
  public CommentService commentService(
      CommentRepository commentRepository,
      CommentNotificationProxy commentNotificationProxy,
      String commentServiceName) {
    return new CommentService(commentRepository, commentNotificationProxy, commentServiceName);
  }

  /*We create a bean for each of the two dependencies.*/
  @Bean
  public CommentRepository commentRepository() {
    return new DBCommentRepository();
  }

  @Bean
  public CommentNotificationProxy commentNotificationProxy() {
    return new EmailCommentNotificationProxy();
  }
}
