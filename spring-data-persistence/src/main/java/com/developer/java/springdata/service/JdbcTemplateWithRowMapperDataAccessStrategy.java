package com.developer.java.springdata.service;

import com.developer.java.springdata.dto.CompanyDTO;
import com.developer.java.springdata.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jdbcTemplateWithRowMapperDataAccessStrategy")
public class JdbcTemplateWithRowMapperDataAccessStrategy implements DataAccessStrategy {

    private final CompanyRepository companyRepository;

    @Autowired
    public JdbcTemplateWithRowMapperDataAccessStrategy(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDTO> getCompanies() {
        return this.companyRepository.findAllCompaniesUsingRowMapper();
    }
}
