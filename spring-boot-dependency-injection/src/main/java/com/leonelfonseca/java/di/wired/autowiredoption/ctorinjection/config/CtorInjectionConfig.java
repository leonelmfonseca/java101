package com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.config;

import com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.component.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
    basePackages = "com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.component")
public class CtorInjectionConfig {

  // No @Bean definitions here, only component scanning

  /**
   * When the application context is initialized, Spring will process the @Configuration classes,
   * using '@ComponentScan(basePackages ="<package>")' instantiate them, and use them to create and manage
   * the beans defined within.
   * This approach ensures that all your beans, whether defined via @Component scanning or @Configuration
   * classes,are managed consistently by Spring.
   */

  @Bean
    public Dog ginger(){
      return new Dog();
  }

}
