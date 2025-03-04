package com.developer.java.appcontext.config;

import com.developer.java.appcontext.model.Transportation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * A configuration class is a special class in Spring applications that we use to instruct
 * Spring to do specific actions.
 */
@Configuration
public class TransportionConfig {

  /*
   * For example, we can tell Spring to create beans.
   * By adding the @Bean annotation, we instruct Spring
   * to call this method when at context initialization and
   * add the returned value to the context.
   */

  @Bean
  Transportation transportation() {

    var transportation = new Transportation();

    transportation.setType("public");
    transportation.setCapacity(50);
    transportation.setFuelType("gasoline");

    // Spring adds to its context the Parrot
    // instance returned by the method.
    return transportation;
  }

  @Bean
  String hello() {
    return "Hello";
  }

  @Bean
  Integer ten() {
    return 10;
  }
}
