//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san.service
//File Name						: BootstrapService.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 1:01:18 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class BootstrapService {

	@PostConstruct
	public void init() {
	}

	@PreDestroy
	public void destroy() {
	}

	public void startup() {
	}

	public void shutdown() {
	}

}
