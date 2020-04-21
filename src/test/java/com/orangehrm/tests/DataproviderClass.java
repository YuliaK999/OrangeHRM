package com.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class DataproviderClass {

	@DataProvider
	public static Object[][] addLanguages(){

	Object[][] LangData = new Object[][] {
	{"Russian","Turkish","English"},
	};
	return LangData;
	}


	@DataProvider
	public static Object[][] addSkills(){

	Object[][] SkillData = new Object[][] {
	{"teamwork","leadership","communication"},
	};
	return SkillData;
	}


	@DataProvider
	public static Object[][] employeeInfo() {

	Object[][] Data = new Object[][] { { "Ali" , "Khan", "Admin", "admin123" ,"admin123" }, };
	return Data;
	}
	
	@DataProvider
	public static Object[][] addCustomFields(){

	Object[][] FieldData = new Object[][] { { "Hobby" , "Sport", "Nationality", "Race" ,"Education" }, };
	return FieldData;
	}


}
