package com.thoughtworks.challenge.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Kuldeep Jha
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	Docket inventoryApi() {

		List<Parameter> operationParameters = new ArrayList<>();
		operationParameters.add(new ParameterBuilder().name(Constants.CONTEXT_CODE).defaultValue("application/json")
				.description("You should know it in advance").modelRef(new ModelRef(Constants.STRING))
				.parameterType(Constants.HEADER).required(false).build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.thoughtworks.challenge"))
				.paths(PathSelectors.ant("/**")).build().apiInfo(apiInfo())
				.globalOperationParameters(operationParameters);

	}

	static ApiInfo apiInfo() {
		return new ApiInfo("REST API Documentation", Constants.EMPTY_STRING, "1.0", Constants.EMPTY_STRING,
				new Contact("Support", "https://github.com/kuldeepjha", "kuldeepjha09@gmail.com"), Constants.EMPTY_STRING,
				Constants.EMPTY_STRING);
	}
}