package com.tcs.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
@EnableFeignClients
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
	
	@Bean
  public ObjectMapper objectMapper() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      mapper.registerModules(new ProblemModule(), new ConstraintViolationProblemModule());
      return mapper;
  }
}