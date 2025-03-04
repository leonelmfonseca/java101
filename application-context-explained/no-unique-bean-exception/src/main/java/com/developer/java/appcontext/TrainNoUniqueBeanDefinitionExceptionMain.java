package com.developer.java.appcontext;

import com.developer.java.appcontext.config.TrainConfig;
import com.developer.java.appcontext.model.Train;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainNoUniqueBeanDefinitionExceptionMain {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(TrainConfig.class);
      Train train = null;
      try {
          /*
           * Of course, you can’t get the beans from the context anymore by only specifying the
           * type. If you do, you’ll get an exception(NoUniqueBeanDefinitionException) because Spring cannot guess which instance
           * you’ve declared you refer to.
           */
          train = context.getBean(Train.class);
      } catch (NoUniqueBeanDefinitionException e) {
        System.out.println(e.getMessage());
        return;
      }
      System.out.println(train.getName());
  }
}