package com.jpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jpa.demo.entity")
public class SpringBootApplicationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationProjectApplication.class, args);
	}

}
