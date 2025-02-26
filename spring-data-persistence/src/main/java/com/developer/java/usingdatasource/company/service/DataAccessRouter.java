package com.developer.java.usingdatasource.company.service;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataAccessRouter {

  private final Map<String, DataAccessStrategy> strategyMap;
  private final DataAccessStrategy defaultDataAccessStrategy;

  @Autowired
  public DataAccessRouter(List<DataAccessStrategy> strategies, @Qualifier("jdbcTemplateWithRowMapperDataAccessStrategy") DataAccessStrategy defaultDataAccessStrategy) {
    strategyMap =
        strategies.stream()
            .collect(
                Collectors.toMap(
                    strategy -> strategy.getClass().getSimpleName(), Function.identity()));
      this.defaultDataAccessStrategy = defaultDataAccessStrategy;
  }

  public List<CompanyDTO> getCompanies(String strategyType) {

    DataAccessStrategy strategy =
        strategyMap.getOrDefault(strategyType, defaultDataAccessStrategy);
    return strategy.getCompanies();

  }
}
