package com.pbricks.ShoppingSuite;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pbricks.util.ErrorUtil;
import com.pbricks.util.Selenium;

public class ShopLoginTest1 extends SHPTestSuiteBase{
	
	@BeforeTest
	public void CheckTestSkip(){
		APP_LOGS.debug("Checking if test is runnable" + "--"+ this.getClass().getSimpleName());
		if(Selenium.isTestCaseRunnable(SHPSuiteXls, "TestCases", "TCID", "RUNMODE", "ShopLoginTest1") != true){	
			APP_LOGS.debug("Test Case will be skipped"  + "--" + this.getClass().getSimpleName());
			throw new SkipException("Test Case skipped" + "ShopLoginTest1");
		}	else{	
		APP_LOGS.debug("RunMode is Yes" + "---" +this.getClass().getSimpleName());
		}
		
	}

     @Test(dataProvider ="Testdata")
     public void ShopLoginTest10(Hashtable<String,String>table){
	System.out.println(table.get("UserName"));
	System.out.println(table.get("Password"));
}
     
     
     @DataProvider
     public Object[][] Testdata(){
    	 
    	 return Selenium.getData("Data", "ShopLoginTest1", SHPSuiteXls);
     }
}


