package com.howtodoinjava.demo;

import org.junit.Assert;
// import org.junit.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckDelete {
	
	@Test
	public void checkDeleteRequest() {
			
		int empid = 4;
			
		RestAssured.baseURI = "http://localhost:8091";
		RequestSpecification request = RestAssured.given();	
			
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");	
		
	       // Delete the request and check the response
		Response response = request.delete("employees/"+ empid);		
			
		System.out.println(response.asString());
		
		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
			
		String jsonString =response.asString();
		Assert.assertEquals(jsonString.contains("FORBIDDEN"), true);
		}

}
