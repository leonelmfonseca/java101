package com.leonelfonseca.java.springcontextabstractions.withspring.model;

import lombok.Data;

/**
 * Model package is not specified in @ComponentScan of @Configuration class because it doesn’t
 * contain stereotype annotations
 */
@Data
public class Comment {

  private String author;
  private String text;
}
