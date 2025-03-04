package com.developer.java.appcontext.beanambiguity;

import com.developer.java.appcontext.beanambiguity.config.TrainConfig;
import com.developer.java.appcontext.beanambiguity.model.Train;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrainBeanAmbiguitySolvedMain {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(TrainConfig.class);

    /*
     * First parameter is the name of the instance to which we refer
     */
    Train railwayCrane = context.getBean("trainVolkerRail", Train.class);
    System.out.println(railwayCrane);

    // Calling by the name it was defined in @Bean annotation of config class
    Train irconNewTrain = context.getBean("IrconInternationalLimited", Train.class);
    System.out.println(irconNewTrain);

  }
}