package com.qa.Student;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.pojo.DataPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


	public class StudentApiWithObjectmapper 
	{
		@Test
		public void studentTest() throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts";
		//log.info("Restassured base url configured");
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType("application/json").get();
		ObjectMapper mapper = new ObjectMapper();
		String responseStr = response.getBody().asString();
		List<DataPOJO> dataObj = mapper.readValue(responseStr, new TypeReference<List<DataPOJO>>(){});
		System.out.println(dataObj.get(0).getId());
		List<Integer> listOfUserIds = new ArrayList<>();
		List<String> Listoftitles = new ArrayList<>();
		for(int i=0; i< dataObj.size();i++) 
		{
			int userid = dataObj.get(i).getUserId();
			listOfUserIds.add(userid);
			if(userid ==7) {
				Listoftitles.add(dataObj.get(i).getTitle());
			}
		}
		 System.out.println("List of all userids :" +listOfUserIds);
		 //To validate userIds from response contains userid = 7
		Assert.assertTrue(listOfUserIds.contains(7),"not found");
		// to print the title of user id 7
		System.out.println("List of all titles :" +Listoftitles);
		}
	}
