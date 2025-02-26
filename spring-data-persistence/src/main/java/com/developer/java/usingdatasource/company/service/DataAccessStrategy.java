package com.developer.java.usingdatasource.company.service;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import java.util.List;

public interface DataAccessStrategy {

    List<CompanyDTO>  getCompanies();
}
