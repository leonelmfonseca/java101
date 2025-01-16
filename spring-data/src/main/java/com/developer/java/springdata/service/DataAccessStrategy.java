package com.developer.java.springdata.service;

import com.developer.java.springdata.dto.CompanyDTO;

import java.util.List;

public interface DataAccessStrategy {

    List<CompanyDTO>  getCompanies();
}
