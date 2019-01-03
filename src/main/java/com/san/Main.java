//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san
//File Name						: Main.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 12:38:45 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.san.constants.AppConstants;
import com.san.service.BootstrapService;
import com.san.service.PropertiesHelperService;

@SpringBootApplication
public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(Main.class, args);
		BootstrapService bootstrapService = appContext.getBean(BootstrapService.class);
		bootstrapService.startup();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				bootstrapService.shutdown();
				logger.info("Shutdown Hook is running !");
			}
		});
		logger.info("Application started ... ");
		PropertiesHelperService propertiesHelperService = appContext.getBean(PropertiesHelperService.class);
		logger.info("API URL : http://127.0.0.1:" + propertiesHelperService.SERVER_PORT + "/" + AppConstants.SWAGGER_URL);
	}

	@Lazy
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*").allowedHeaders("*");
			}
		};
	}
}
