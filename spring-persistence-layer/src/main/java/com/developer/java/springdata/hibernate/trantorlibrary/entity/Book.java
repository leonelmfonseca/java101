package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Book")
public class Book extends Resource {
  private String author;
  private String isbn;
  private LocalDate publishedDate;
  private String language;
  private String genre;
}
