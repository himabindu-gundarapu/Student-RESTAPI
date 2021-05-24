package com.qa.Student;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
public class StudentTestcase {
	Logger log = Logger.getLogger(StudentTestcase.class);
	@Test
	public void verifyJsonResponse() 
	{
//		Logger log = Logger.getLogger(StudentTestcase.class);
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RestAssured.basePath ="/posts";
		log.info("*****************Restassured base url configured**************");
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType("application/json").get();
		//print response body
		System.out.println("Response body " +response.body().asString());
		
		//getting all userIDS list from response
		List<Integer> userIDS = response.jsonPath().get("userId");
		// print all userids
		System.out.println("useids : " + userIDS);
		Assert.assertTrue(userIDS.contains(7));
		//getting all titles from reposne body
		List<String> titleslist = response.jsonPath().getList("title");
		System.out.println("Titles are :"+titleslist);
		for(int i=0; i<userIDS.size();i++) {
			if(userIDS.get(i) ==7) {
			System.out.println("tile of the given UserId  :"+titleslist.get(i));
			}
			}
		
		}

}
