package com.developer.java.springjpa.repository;

import com.developer.java.springjpa.DTO.CompanyDTO;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/* This annotation not only marks the class as a repository but also registers
it as a Spring-managed bean in the application context. */
@Repository
public class CompanyRepository {
  private final JdbcTemplate jdbc;

  /* By including the H2 dependency in the pom.xml, Spring Boot seamlessly
  configures a data source and instantiates JdbcTemplate, allowing for
  constructor injection to retrieve the JdbcTemplate from the application
  context. */
  public CompanyRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public void createCompany(CompanyDTO companyModel) {
    String sql = "INSERT INTO company VALUES (NULL, ?, ?)";

    // Method sends SQL query with placeholders replaced by provided arguments.
    jdbc.update(
        sql,
        companyModel.getName(),
        companyModel.getFoundationYear(),
        companyModel.getStockTicker());
  }

  // Old-School data access approach
  public List<CompanyDTO> findAllCompaniesUsingRowMapper() {
    String sql = "SELECT * FROM company";

    /* ResultSet retrieves query results row by row, while RowMapper maps ResultSet rows to custom objects, like CompanyDTO, simplifying data conversion and reducing boilerplate. */
    RowMapper<CompanyDTO> companyDTORowMapper =
        (resultSet, rowNumber) -> {
          CompanyDTO company = new CompanyDTO();
          company.setId(resultSet.getLong("id"));
          company.setName(resultSet.getString("company_name"));
          company.setFoundationYear(resultSet.getInt("foundation_year"));
          company.setStockTicker(resultSet.getString("stock_ticker"));
          return company;
        };
    /* In our implementation, we utilize the SELECT query through the query
    method of JdbcTemplate. This approach allows us to effectively retrieve
    data from our database. To ensure accurate transformation of the
    retrieved data into Company objects, we provide a dedicated row mapper. */
    return jdbc.query(sql, companyDTORowMapper);
  }
}
