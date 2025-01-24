package com.developer.java.springdata.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomDataSourceConfiguration {

  // Avoid "magic numbers" and use constants that describe the purpose of it.
  public static final int CONNECTION_TIMEOUT_MS = 1000;

  // Configurable connection details, defined in properties file, out of the source code
  @Value("${custom.datasource.url}")
  private String datasourceUrl;

  @Value("${custom.datasource.username}")
  private String datasourceUsername;

  @Value("${custom.datasource.password}")
  private String datasourcePassword;

  @Bean(name = "customDataSource")
  public DataSource dataSource() { // If Spring Boot finds a DataSource that already exists in the Spring context
                     // it won't configure one

    // We will use Hikari Connection Pool, but you can choose other implementations
    HikariDataSource dataSource = new HikariDataSource();

    // Set the connection parameters on the data source.
    dataSource.setJdbcUrl(datasourceUrl);
    dataSource.setUsername(datasourceUsername);
    dataSource.setPassword(datasourcePassword);
    dataSource.setConnectionTimeout(CONNECTION_TIMEOUT_MS);
    return dataSource;

  }
}
