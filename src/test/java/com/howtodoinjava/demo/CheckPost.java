package com.howtodoinjava.demo;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

//import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckPost {
	
	@Test
	public void checkPostRequests()
	{		
		RestAssured.baseURI ="http://localhost:8091";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 300);
		requestParams.put("firstName", "Anshul"); // Cast
		requestParams.put("lastName", "Bansal");
		requestParams.put("email",  "anshul@gmail.com");
		request.body(requestParams);
		
		System.out.println("Input ==================="+requestParams.toJSONString());
		Response response = request.post("/employees");

		int statusCode = response.getStatusCode();
		
		System.out.println("statusCode =================="+statusCode);
		Assert.assertEquals(statusCode, 200);
//		 String successCode = response.jsonPath().get("SuccessCode");
//		 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}
