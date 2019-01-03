//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san.repositories
//File Name						: TestRepository.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 1:10:31 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.repositories;

import org.springframework.data.repository.CrudRepository;

import com.san.entities.Test;

public interface TestRepository extends CrudRepository<Test, Long> {

}
