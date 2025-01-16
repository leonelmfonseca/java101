package com.developer.java.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

  private Long id;
  private String name;
  private Integer foundationYear;
  private String stockTicker;


}
