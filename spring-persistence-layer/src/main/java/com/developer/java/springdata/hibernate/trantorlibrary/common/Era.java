package com.developer.java.springdata.hibernate.trantorlibrary.common;

import java.util.Optional;

public enum Era {
  GALACTIC("Galactic era", "GE", 12066),
  FOUNDATION("Foundation era", "FE", null);

  private final String eraDescription;
  private final String eraAbbreviation;
  private final Integer currentEraYearStartNextEra;

  Era(String eraDescription, String eraAbbreviation, Integer currentEraYearStartNextEra) {
    this.eraDescription = eraDescription;
    this.eraAbbreviation = eraAbbreviation;
    this.currentEraYearStartNextEra = currentEraYearStartNextEra;
  }

  public Integer convertGalacticYearToFoundationYears(Integer galacticYear) {
    Integer startYear = Optional.ofNullable(currentEraYearStartNextEra)
        .orElseThrow(() -> new IllegalStateException("Era start year cannot be null"));

    if (galacticYear < startYear) {
      throw new IllegalArgumentException(
          "Galactic year must be greater than or equal to the era's start year.");
    }

    return galacticYear - startYear;
  }

  public Integer convertFoundationYearToGalacticYears(Integer foundationYear) {
    if (GALACTIC.currentEraYearStartNextEra == null) {
      throw new IllegalStateException("Galactic era's start year is not defined.");
    }

    return foundationYear + GALACTIC.currentEraYearStartNextEra;
  }
}
