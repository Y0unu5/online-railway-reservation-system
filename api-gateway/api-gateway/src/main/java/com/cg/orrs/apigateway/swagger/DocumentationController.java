package com.cg.orrs.apigateway.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Primary
@EnableAutoConfiguration
@EnableSwagger2
public class DocumentationController implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("admin-service", "/admin/v2/api-docs", "1.0"));
		resources.add(swaggerResource("passenger-service", "/passenger/v2/api-docs", "1.0"));
		resources.add(swaggerResource("train-service", "/train/v2/api-docs", "1.0"));
		resources.add(swaggerResource("ticket-service", "/ticket/v2/api-docs", "1.0"));

		return resources;
	}

	private SwaggerResource swaggerResource(String name, String uri, String version) {
		SwaggerResource resource = new SwaggerResource();
		resource.setName(name);
		resource.setLocation(uri);
		resource.setSwaggerVersion(version);
		return resource;
	}

}
