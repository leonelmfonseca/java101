package com.developer.java.springdata.service;

import com.developer.java.springdata.dto.CompanyDTO;
import com.developer.java.springdata.repository.CompanyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
  private CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<CompanyDTO> findAll() {
    return this.companyRepository.findAllCompaniesUsingRowMapper();
  }
}
