//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san.service
//File Name						: PropertiesHelperService.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 1:53:13 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHelperService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${server.port}")
	public String SERVER_PORT;

}
