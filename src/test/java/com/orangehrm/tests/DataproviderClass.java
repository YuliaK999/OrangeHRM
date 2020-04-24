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
	{"1","2","3"},
	};
	return SkillData;
	}
	
	@DataProvider	//execute the test 2 times
	public static Object[][] keyWordSearch(){

	Object[][] keyWordEmployee = new Object[][] {
	{"L","Linda Anderson"},
	{"f","Thomas Fleming"},
	{"r","Jasmine Morgan"},
	//{"A","Robert Craig"},
	//{"f","Thomas Fleming"},
	};
	return keyWordEmployee;
	}


	@DataProvider
	public static Object[][] employeeInfo() {

	Object[][] Data = new Object[][] { { "Ali" , "Khan", "Alikhan", "alikhan123" ,"alikhan123" }, };
	return Data;
	}
	
	@DataProvider
	public static Object[][] addCustomFields(){

	Object[][] FieldData = new Object[][] { { "Hobby" , "Sport", "Nationality", "Race" ,"Education" }, };
	return FieldData;
	}


}
