package com.leonelfonseca.java.appcontext;

import com.leonelfonseca.java.appcontext.config.TrainConfig;
import com.leonelfonseca.java.appcontext.model.Train;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainNoUniqueBeanDefinitionExceptionMain {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(TrainConfig.class);
    /*
     * Of course, you can’t get the beans from the context anymore by only specifying the
     * type. If you do, you’ll get an exception(NoUniqueBeanDefinitionException) because Spring cannot guess which instance
     * you’ve declared you refer to.
     */
    Train train = context.getBean(Train.class);

    System.out.println(train.getName());
  }
}