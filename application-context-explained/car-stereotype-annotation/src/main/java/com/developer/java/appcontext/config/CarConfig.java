package com.developer.java.appcontext.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Using the basePackages attribute of the annotation, we tell Spring where to look
 * for classes annotated with stereotype annotations.
 */
@ComponentScan(basePackages = "com.developer.java.appcontext.model")
@Configuration
public class CarConfig {

}
