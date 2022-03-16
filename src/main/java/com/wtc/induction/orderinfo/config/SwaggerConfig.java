package com.wtc.induction.orderinfo.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.wtc.induction.orderinfo"))
				.paths(PathSelectors.regex("/.*")).build()
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
				.apiInfo(apiInfo());
		}
		
		private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
				.title("Order Info")
				.description("Rest API For Order Info")
				.version("1.0.0")
				.license("Apache 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
				.contact(new Contact("WTC", "https://www.wundermanthompson.com", "wtc@wundermanthompson"))
				.build();
		}

}
