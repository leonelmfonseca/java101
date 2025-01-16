package com.developer.java.springjpa.DTO;

import lombok.Data;

@Data
public class CompanyDTO {

  private Long id;
  private String name;
  private Integer foundationYear;
  private String stockTicker;


}
