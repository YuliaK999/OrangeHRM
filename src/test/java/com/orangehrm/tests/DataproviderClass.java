package com.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class DataproviderClass {

	@DataProvider // 2 times with 3 parameters

	public static Object[][] addLanguages() {

		Object[][] LangData = new Object[][] { { "Russian", "Turkish", "English", "French" }, };
		return LangData;
	}

	@DataProvider
	public static Object[][] employeeInfo() {

		Object[][] Data = new Object[][] { { "Ali" , "Khan", "Admin", "admin123" ,"admin123" }, };
		return Data;
	}

}
