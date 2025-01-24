package com.developer.java.springdata.service;

import com.developer.java.springdata.dto.CompanyDTO;
import com.developer.java.springdata.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

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
