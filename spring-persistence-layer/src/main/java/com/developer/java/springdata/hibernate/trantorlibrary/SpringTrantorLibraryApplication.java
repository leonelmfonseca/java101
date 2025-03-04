package com.developer.java.springdata.hibernate.trantorlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringTrantorLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTrantorLibraryApplication.class, args);
	}

}
