package com.howtodoinjava.demo;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVWriter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;

public class APITesting {
		
	 	// @Test
		public void checkGetRequest()
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "http://localhost:8091";

			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();

			// Make a request to the server by specifying the method Type and the method URL.
			// This will return the Response from the server. Store the response in a variable.
			Response response = httpRequest.request(Method.GET, "/employees");

			// Now let us print the body of the message to see what response
			// we have recieved from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);

		} 		
	 	
		//@Test
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
			
		
		/* 
		@Test
		public void UpdateRecords(){
				int empid = 6;

				RestAssured.baseURI ="http://localhost:8091";
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				
				JSONObject requestParams = new JSONObject();
				requestParams.put("id", 6);
				requestParams.put("firstName", "Rahul"); // Cast
				requestParams.put("lastName", "Chaudhary");
				requestParams.put("email",  "rahul@gmail.com");

				request.body(requestParams.toJSONString());
				Response response = request.put("/employees/"+ empid);

				int statusCode = response.getStatusCode();
				System.out.println(response.asString());
				Assert.assertEquals(statusCode, 200); 

			}
		
		
*/
		

		//@Test
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
//			 String successCode = response.jsonPath().get("SuccessCode");
//			 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		} 
		
		//@Test
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
//			 String successCode = response.jsonPath().get("SuccessCode");
//			 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		}
		
		
	}
