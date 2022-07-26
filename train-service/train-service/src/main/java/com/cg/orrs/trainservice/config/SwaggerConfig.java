package com.cg.orrs.trainservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().paths(PathSelectors.any()).build();

	}

	private ApiInfo getInfo() {
		return new ApiInfo("Train Microservice", "Train Microservice for Online Railway Reservation System", "1.0",
				"Terms Of Service",
				new Contact("Mahmad Yunus", "https://github.com/Y0unu5/Y0unu5", "mkyounus541@gmail.com"),
				"License of APIS", "API license URL", Collections.emptyList());
	}
}
