package com.developer.java.usingdatasource.company.service;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import com.developer.java.usingdatasource.company.repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
