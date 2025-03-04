package com.developer.java.usingdatasource.company.service;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import com.developer.java.usingdatasource.company.repository.CompanyRepository;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomDataSourceDataAccessStrategy implements DataAccessStrategy {

  private final CompanyRepository companyRepository;
  private final DataSource dataSource;

  @Autowired
  public CustomDataSourceDataAccessStrategy(CompanyRepository companyRepository, DataSource dataSource) {
    this.companyRepository = companyRepository;
      this.dataSource = dataSource;
  }

  @Override
  public List<CompanyDTO> getCompanies() {
    return companyRepository.findAllCompaniesUsingCustomDatasource(dataSource);
  }
}
