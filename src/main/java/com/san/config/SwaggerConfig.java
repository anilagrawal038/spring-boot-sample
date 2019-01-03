//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san.config
//File Name						: SwaggerConfig.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 1:58:48 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.san.constants.AppConstants;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage("com.san.rest")) //
				// .paths(PathSelectors.regex(AppConstants.API_URL_PREFIX + "/*")) //
				.paths(PathSelectors.any()) //
				.build() //
				.apiInfo(metaData());
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo( //
				"Spring Boot REST API", //
				"Spring Boot REST API for Online Store", //
				"1.0", //
				"Terms of service", //
				new Contact("Anil Agrawal", "https://springframework.com/about/", "anil@springfrmework.com"), //
				"Apache License Version 2.0", //
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(AppConstants.SWAGGER_URL).addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}