package com.howtodoinjava.demo;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

// import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckPut {
	
	@Test
	public void checkPutRequests()
	{		
		RestAssured.baseURI ="http://localhost:8091";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 3);
		requestParams.put("firstName", "RSystems"); // Cast
		requestParams.put("lastName", "RSystems");
		requestParams.put("email",  "rsys@gmail.com");
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
