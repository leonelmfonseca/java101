package com.developer.java.usingdatasource.company.service;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import com.developer.java.usingdatasource.company.repository.CompanyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
  private final CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<CompanyDTO> findAll() {
    return this.companyRepository.findAllCompaniesUsingRowMapper();
  }
}
