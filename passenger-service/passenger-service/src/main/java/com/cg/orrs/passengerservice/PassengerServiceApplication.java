package com.cg.orrs.passengerservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class PassengerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerServiceApplication.class, args);
	}

	/**
	 * @Bean is applied on method to specify that it returns a bean to be managed by
	 *       spring context.
	 * @ModelMapper Model Mapper is a an object to object framework that converts
	 *              Java Beans from one representation to another.
	 * 
	 * @return new ModelMapper
	 */

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
