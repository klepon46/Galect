package com.galectapp.GalectApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.galect.bean" })
@EnableJpaRepositories(basePackages = { "com.galect.repository" })
public class GalectAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalectAppApplication.class, args);
	}
}
