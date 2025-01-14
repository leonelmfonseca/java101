package com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.proxies;

import com.leonelfonseca.java.springcontextabstractions.qualifierannotationsetdefaultimplementation.model.Comment;
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
