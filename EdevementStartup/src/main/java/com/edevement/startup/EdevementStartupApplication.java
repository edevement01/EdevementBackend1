package com.edevement.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.edevement.startup"})
@EntityScan(basePackages = {"com.edevement.startup"})
@EnableJpaRepositories(basePackages = {"com.edevement.startup"})
@EnableTransactionManagement
@EnableCaching
public class EdevementStartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdevementStartupApplication.class, args);
	}

}
