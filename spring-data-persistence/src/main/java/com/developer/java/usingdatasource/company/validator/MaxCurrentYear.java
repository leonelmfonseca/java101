package com.developer.java.usingdatasource.company.validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrentYearValidator.class)
public @interface  MaxCurrentYear {
    // Part of the custom annotation in the Java Bean Validation (JSR 303/JSR 380) framework.
    // They define the behavior and metadata of  custom constraint
    String message() default "Year cannot exceed the current year";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
