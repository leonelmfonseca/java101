package com.developer.java.appcontext.config;

import com.developer.java.appcontext.model.Train;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * A configuration class is a special class in Spring applications that we use to instruct
 * Spring to do specific actions.
 */
@Configuration
public class TrainConfig {

  /*
   * For example, we can tell Spring to create beans.
   * By adding the @Bean annotation, we instruct Spring
   * to call this method when at context initialization and
   * add the returned value to the context.
   */

  @Bean
  Train train() {

    var train = new Train();

    train.setId("1");
    train.setCapacity(200);
    train.setName("Train");

    return train;
  }

  @Bean
  Train trainAlstom() {

    var train = new Train();

    train.setId("1");
    train.setCapacity(1000);
    train.setName("Alstom");

    return train;
  }

  @Bean
  Train trainVolkerRail() {

    var train = new Train();

    train.setId("2");
    train.setCapacity(800);
    train.setName("VolkerRail");

    return train;
  }

  @Bean
  Train trainSwietelsky() {

    var train = new Train();

    train.setId("3");
    train.setCapacity(900);
    train.setName("Swietelsky");

    return train;
  }

  /*
   * If you’d like to give another name to the bean, you can use either one of the name
   * or the value attributes of the @Bean annotation. Any of the following syntaxes will
   * change the name of the bean
   */

  // @Bean(value = "IrconInternational")
  // @Bean("InternationalLimited")
  @Bean(name = "IrconInternationalLimited")
  Train trainIRCON() {

    var train = new Train();

    train.setId("4");
    train.setCapacity(900);
    train.setName("IRCON");

    return train;
  }

}
