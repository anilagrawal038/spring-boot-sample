//-----------------------------------------------------------------------------------------------------------
//					ORGANIZATION NAME
//Group							: Common - Project
//Product / Project				: spring-boot-sample
//Module						: spring-boot-sample
//Package Name					: com.san.rest
//File Name						: TestController.java
//Author						: anil
//Contact						: anilagrawal038@gmail.com
//Date written (DD MMM YYYY)	: 04-Jan-2019 12:42:16 AM
//Description					:  
//-----------------------------------------------------------------------------------------------------------
//					CHANGE HISTORY
//-----------------------------------------------------------------------------------------------------------
//Date			Change By		Modified Function 			Change Description (Bug No. (If Any))
//(DD MMM YYYY)
//04-Jan-2019   	anil			N/A							File Created
//-----------------------------------------------------------------------------------------------------------

package com.san.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.san.constants.AppConstants;
import com.san.entities.Test;
import com.san.repositories.TestRepository;
import com.san.to.RequestTO;
import com.san.to.ResponseTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { //
		@ApiResponse(code = 200, message = "Successfully retrieved response"), //
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"), //
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"), //
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") //
})
@RequestMapping(path = AppConstants.API_URL_PREFIX)
@RestController
public class TestController {

	@Autowired
	TestRepository testRepository;

	@ApiOperation(value = "Test GET API", response = ResponseTO.class)
	@RequestMapping(path = "/test", method = RequestMethod.GET, produces = "application/json")
	public ResponseTO test() {
		ResponseTO response = new ResponseTO();
		Test test = new Test();
		test.setMessage("test object added at epoch time : " + System.currentTimeMillis());
		test = testRepository.save(test);
		if (test.getId() > 0) {
			response.setStatus(true);
		}
		System.out.println("test object count : " + testRepository.count());
		return response;
	}

	@ApiOperation(value = "Test UPDATE API", response = ResponseTO.class)
	@RequestMapping(path = "/test", method = RequestMethod.PUT, produces = "application/json")
	public ResponseTO updateInfo(@PathVariable Integer id, @RequestBody RequestTO request) {
		ResponseTO response = new ResponseTO();
		response.setStatus(true);
		return response;
	}

}
