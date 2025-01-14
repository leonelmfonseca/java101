package com.leonelfonseca.java.di.circulardependencies;

import com.leonelfonseca.java.di.circulardependencies.config.CircularDependenciesConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiCircularDependenciesApplication {

  public static void main(String[] args) {

    System.out.println("Circular dependencies");
    System.out.println();

    /**
     * Spring can also get confused in some cases. A scenario often encountered in practice is
     * generating a circular dependency by mistake. A circular dependency is a situation in which,
     * to create a bean (in our scenario Person), Spring needs to inject another bean that doesn’t
     * exist yet (Cat). But Bean Cat also requests a dependency to Bean Person(check component
     * package). So, to create Bean Cat, Spring needs first to have Bean Person. Spring is now in a
     * deadlock. It cannot create Bean Person because it needs Bean Cat, and it cannot create Bean
     * Cat because it needs Bean Person.
     */
    circularDependenciesDemo();
  }

  private static void circularDependenciesDemo() {

    var context = new AnnotationConfigApplicationContext(CircularDependenciesConfig.class);

    /**
     * Running the app with such a configuration will lead to an exception like:
     *
     * <p>Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error
     * creating bean with name 'circularDependenciesPerson' defined in file
     * [/..../spring-boot-dependency-injection/target/classes/com/leonelfonseca/java/di/circulardependencies/component/CircularDependenciesPerson.class]:
     * Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with
     * name 'circularDependenciesCat': Requested bean is currently in creation: Is there an
     * unresolvable circular reference or an asynchronous initialization dependency?
     */

    // This code will return compilation error
    // CircularDependenciesPerson johnny = context.getBean(CircularDependenciesPerson.class);

  }
}
