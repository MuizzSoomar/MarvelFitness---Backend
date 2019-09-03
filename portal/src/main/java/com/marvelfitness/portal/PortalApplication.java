package com.marvelfitness.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.marvelfitness"})
@EnableJpaRepositories(basePackages = {"com.marvelfitness.portal.authentication", "com.marvelfitness.portal.config",
		"com.marvelfitness.portal.customer", "com.marvelfitness.portal.employee", "com.marvelfitness.portal.rewards",
		"com.marvelfitness.portal.visits"})
@EntityScan(basePackages="com.marvelfitness.portal")
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}
