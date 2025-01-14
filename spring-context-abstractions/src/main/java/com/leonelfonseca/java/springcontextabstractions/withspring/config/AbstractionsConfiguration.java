package com.leonelfonseca.java.springcontextabstractions.withspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * @ComponentScan annotation tell Spring in which packages to search for the classes annotated with
 * stereotype annotations. Observe that the model package is not specified because it doesn’t
 * contain classes annotated with stereotype annotations.
 */
@ComponentScan(
    /**
     * you only have to mention the pack age name. In case it contains N component classes, you
     * write only one line (the name of the package) instead of N.
     */
    basePackages = {"com.leonelfonseca.java.springcontextabstractions.withspring"})
public class AbstractionsConfiguration {}
