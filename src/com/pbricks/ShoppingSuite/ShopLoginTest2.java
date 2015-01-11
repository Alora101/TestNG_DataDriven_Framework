package com.pbricks.ShoppingSuite;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;

import com.pbricks.util.Selenium;

public class ShopLoginTest2 extends SHPTestSuiteBase{
	
	@BeforeTest
	public void CheckTestSkip(){
		APP_LOGS.debug("Checking if test is runnable" +"--"+ this.getClass().getSimpleName());
		if(Selenium.isTestCaseRunnable(SHPSuiteXls, "TestCases", "TCID", "RUNMODE", "ShopLoginTest2") != true){
			
			APP_LOGS.debug("Test Case will be skipped"  +"--"+ this.getClass().getSimpleName());
			throw new SkipException("Test Case skipped" +"--"+  this.getClass().getSimpleName());
		}
		
		APP_LOGS.debug("RunMode is Yes" +"--"+ this.getClass().getSimpleName());
	}

}
