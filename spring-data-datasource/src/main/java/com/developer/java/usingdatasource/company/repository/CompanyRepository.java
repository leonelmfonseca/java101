package com.developer.java.usingdatasource.company.repository;

import com.developer.java.usingdatasource.company.dto.CompanyDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/* This annotation not only marks the class as a repository but also registers
it as a Spring-managed bean in the application context. */
@Repository
public class CompanyRepository {
  private JdbcTemplate jdbcTemplate;

  /* By including the H2 dependency in the pom.xml, Spring Boot seamlessly
  configures a data source and instantiates JdbcTemplate, allowing for
  constructor injection to retrieve the JdbcTemplate from the application
  context. */
  public CompanyRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void createCompany(CompanyDTO companyModel) {
    String sql = "INSERT INTO company VALUES (NULL, ?, ?)";

    // Method sends SQL query with placeholders replaced by provided arguments.
    jdbcTemplate.update(
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
    /* In our implementation, we use the SELECT query through the query
    method of JdbcTemplate. This approach allows us to effectively retrieve
    data from our database. To ensure accurate transformation of the
    retrieved data into Company objects, we provide a dedicated row mapper. */
    return jdbcTemplate.query(sql, companyDTORowMapper);
  }

  public List<CompanyDTO> findAllCompaniesUsingCustomDatasource(
      @Qualifier("customDataSource") DataSource dataSource) {

    // This will require that jdbcTemplate can't be "final"
    // You've now created a custom data source and pass it to jdbcTemplate
    this.jdbcTemplate = new JdbcTemplate(dataSource);

    String sql = "SELECT * FROM company";

    return jdbcTemplate.query(
        sql,
        (rs, rowNum) ->
            new CompanyDTO(
                rs.getLong("id"),
                rs.getString("company_name"),
                rs.getInt("foundation_year"),
                rs.getString("stock_ticker")));
  }
}
