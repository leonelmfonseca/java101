package com.developer.java.appcontext;

import net.datafaker.Faker;
import com.developer.java.appcontext.config.BoatConfig;
import com.developer.java.appcontext.model.Boat;
import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterBeanProgramatically {

  private static final Faker faker = new Faker();

  public static void main(String[] args) {

    registeringSingleBean();
  }

  private static void registeringSingleBean() {
    var context = new AnnotationConfigApplicationContext(BoatConfig.class);

    /** We create the instance we want to add to the Spring context */
    Boat nautilus = randomBoat();

    /**
     * We define a Supplier to return this instance. Supplier is a functional interface you find in
     * the java.util.function package. The purpose of a supplier implementation is to return a value
     * you define without taking parameters.
     */
    Supplier<Boat> boatSupplier = () -> nautilus;

    /** We call the registerBean() method to add the instance to the Spring context. */
    context.registerBean("Nautilus", Boat.class, boatSupplier);

    /**
     * To verify the bean is now in the context, we refer to the boat bean and print its name in
     * the console.
     */
    Boat nemosBoat = context.getBean(Boat.class);
    System.out.println(nemosBoat);
  }

  private static Boat randomBoat() {
    var boat = new Boat();

    boat.setName(faker.funnyName().name());
    boat.setLength(faker.number().numberBetween(6, 40));
    boat.setType("Submarine");
    boat.setYearBuilt(faker.number().numberBetween(1971, 2024));
    return boat;
  }
}
