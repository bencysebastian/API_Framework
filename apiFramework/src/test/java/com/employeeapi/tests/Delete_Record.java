package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Record extends TestBase{
	
	RequestSpecification httprequest;
	Response response;
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest =RestAssured.given();
		response= httprequest.request(Method.GET,"/employees");
		JsonPath jsonpathEvaluator=response.jsonPath();
		String EmpID =jsonpathEvaluator.get("[0].id");
		
		response =httprequest.request(Method.DELETE,"/delete/"+EmpID);
		
		Thread.sleep(3);
				
		
	}
	
	
	@Test
	
	void checkresponsebody()
	{
		logger.info("**********Checking Response body*************");
		String responsebody=response.getBody().asString();
		logger.info("responsebody------>"+responsebody);
		Assert.assertEquals(responsebody.contains("successfully! deleted Records"), false);
	}

	
	@Test
	
	void checkstatuscode()
	{
		logger.info("**********Checking status code***************");
		int statuscode =response.getStatusCode();
		logger.info("Status code is--------->"+statuscode);
	}
	
	

	
	@Test
	
	void checkstatusline()
	{
			logger.info("***********Checking status line**************");
			
			String statusline =response.getStatusLine();
			logger.info("Statusline is------------>"+statusline);
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
    @Test

   void CheckContentType()
   {
	logger.info("*************Checking Content Type**************");
	String ContentType =response.contentType();
	logger.info("Content Type------------->"+ContentType);
    	
   }
	
    @AfterClass
    void teardown()
    {
    	logger.info("Finished all Tc01 Activities");
    }

	
	

}
