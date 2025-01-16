package com.developer.java.springjpa.service;

import com.developer.java.springjpa.DTO.CompanyDTO;
import com.developer.java.springjpa.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
