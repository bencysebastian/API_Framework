package com.employeeapi.utiliyies;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String Empname()
	{
		
		String generatedstring =RandomStringUtils.randomAlphabetic(1);
		return("John"+generatedstring);
	}
	public static String Salary()
	{
		
		String generatedstring =RandomStringUtils.randomNumeric(5);
		return(generatedstring);
	}
	public static String Age()
	{
		
		String generatedstring =RandomStringUtils.randomNumeric(2);
		return(generatedstring);
	}

}
