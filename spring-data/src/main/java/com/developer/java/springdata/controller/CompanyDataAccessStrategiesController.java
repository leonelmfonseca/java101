package com.developer.java.springdata.controller;

import com.developer.java.springdata.dto.CompanyDTO;
import com.developer.java.springdata.service.DataAccessRouter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company/")
public class CompanyDataAccessStrategiesController {
  private final DataAccessRouter router;

  // We use constructor dependency injection to get the service object from the Spring context.
  @Autowired
  public CompanyDataAccessStrategiesController(DataAccessRouter router) {
    this.router = router;
  }

  /* An endpoint retrieves all company records, with the controller using the service -> repository to fetch data and
   * returning it in the HTTP response body */
  @GetMapping
  public ResponseEntity<List<CompanyDTO>> getCompanies(@RequestParam String strategy) {
    List<CompanyDTO> companies = router.getCompanies(strategy);
    return ResponseEntity.ok(companies);
  }
}
