package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetAllEmployees extends TestBase{
	
	
	@BeforeClass
	
	public void getallemployees() throws InterruptedException
	{
		logger.info("***************Started TC01 Get all Employees********************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest =RestAssured.given();
		response=httprequest.request(Method.GET,"/employees");
		Thread.sleep(3);
				
	}
	
	@Test
	
	void checkresponsebody()
	{
		logger.info("**********Checking Response body*************");
		String responsebody=response.getBody().asString();
		logger.info("responsebody------>"+responsebody);
		Assert.assertTrue(responsebody!=null);
	}

	
	@Test
	
	void checkstatuscode()
	{
		logger.info("**********Checking status code***************");
		int statuscode =response.getStatusCode();
		logger.info("Status code is--------->"+statuscode);
	}
	
	
	@Test
	
	void CheckResponseTime()
	{
		logger.info("*********Checking response Time****************");
		long responsetime=response.getTime();
		logger.info("response Time is------------->"+responsetime);
		if(responsetime>4000)
			logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responsetime<4000);
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
    
    @Test
    void CheckContentlength()
    {
    	logger.info("****************Checking Content Length*********");
    	String Contentlenghth =response.header("Content-Length");
    	logger.info("Content Length------------>"+Contentlenghth);
    	Assert.assertTrue(Integer.parseInt(Contentlenghth)>100);
    			
    }
    
    @AfterClass
    void teardown()
    {
    	logger.info("Finished all Tc01 Activities");
    }




}

