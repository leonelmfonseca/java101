package com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.proxies;

import com.leonelfonseca.java.springcontextabstractions.singledimultiplemanners.model.Comment;

    /*
        @Configuration class, takes precedence and ensures that Spring will use the bean definition from the configuration class.
        Whether the class has a @Component annotation becomes irrelevant in this context.
        In this scenario, @Component annotation was removed from EmailCommentNotificationProxy class(although we kept it in DBCommentRepository class),
        and program still executes as it should.
    */

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: "
                + comment.getText());
    }
}
