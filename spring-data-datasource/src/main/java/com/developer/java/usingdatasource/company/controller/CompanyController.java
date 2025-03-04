package com.developer.java.usingdatasource.company.controller;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import com.developer.java.usingdatasource.company.service.CompanyService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
  private final CompanyService companyService;

  // We use constructor dependency injection to get the service object from the Spring context.
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  /* An endpoint retrieves all company records, with the controller using the service -> repository to fetch data and
   * returning it in the HTTP response body */
  @GetMapping
  public List<CompanyDTO> getAllCompanies() {
    return this.companyService.findAll();
  }

  // TODO: Determine the most effective way to route requests based on the required data access strategy.
}