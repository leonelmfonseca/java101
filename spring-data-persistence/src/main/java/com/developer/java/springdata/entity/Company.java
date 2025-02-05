package com.developer.java.springdata.entity;

import com.developer.java.springdata.validator.MaxCurrentYear;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Company {
  @Id // Used by the JPA provider to uniquely identify entities during
  // persistence operations
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // Database automatically handles the generation of primary key values
  private Long id;

  @NotNull
  @Column(name = "company_name", length = 100)
  private String name;

  // Custom validator
  @MaxCurrentYear private Integer foundationYear;

  @Size(min = 1, max = 5)
  private String stockTicker;
}
