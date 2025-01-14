package com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.proxies;

import com.leonelfonseca.java.springcontextabstractions.primaryannotationsetdefaultimplementation.model.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: "
                + comment.getText());
        
    }
}
