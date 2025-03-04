package com.developer.java.usingdatasource.company.entity;

import com.developer.java.usingdatasource.company.validator.MaxCurrentYear;
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
  private String name;

  // Custom validator
  @MaxCurrentYear private Integer foundationYear;

  @Size(min = 1, max = 5)
  private String stockTicker;
}
