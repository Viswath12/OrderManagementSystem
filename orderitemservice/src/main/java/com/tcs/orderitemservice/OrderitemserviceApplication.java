package com.tcs.orderitemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OrderitemserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderitemserviceApplication.class, args);
	}
	
	 @Bean
	 public ObjectMapper objectMapper() {
	     return new ObjectMapper().registerModules(
	       new ProblemModule(),
	       new ConstraintViolationProblemModule());
	 }
}