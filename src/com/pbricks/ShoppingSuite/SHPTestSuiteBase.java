package com.pbricks.ShoppingSuite;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.pbricks.base.TestBase;
import com.pbricks.util.Selenium;

public class SHPTestSuiteBase extends TestBase{
	
	@BeforeSuite
	public void isSuiteSkipped() throws Exception{
		    Initialized();
			APP_LOGS.debug("Checking if Suite is runnable.");
			if(Selenium.IsSuiteRunnable(TestSuitesXls, "ShoppingSuite","Suites","TSID","Runmode") != true)
			{			
				APP_LOGS.debug("Suite will be skipped as runmode is No." + "ShoppingSuite");
				throw new SkipException("Test Suite will be skipped as runmode is No.");
			}else			
				APP_LOGS.debug("Suite will be executed." + "ShoppingSuite");				
	}	
}
