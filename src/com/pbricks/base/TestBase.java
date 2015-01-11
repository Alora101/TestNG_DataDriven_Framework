package com.pbricks.base;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.pbricks.util.Xls_Reader;

public class TestBase {
	public static Logger APP_LOGS = null;
	public static Properties Config = null;
	public static Properties OR = null;
	public static Xls_Reader PBSuiteXls = null;
	public static Xls_Reader SHPSuiteXls = null;
	public static Xls_Reader ADRSuiteXls = null;
	public static Xls_Reader TestSuitesXls = null;
	public static boolean isInitialized = false;  //Will use this to avoid multiple initialization f files.
	
	
	//Initialize logs, Configs, OR properties and excel files.
	public void Initialized() throws Exception{
		
		if(!isInitialized){
			APP_LOGS = Logger.getLogger("devpinoyLogger");
			//log files
			APP_LOGS.debug("Loading Property files.");
			Config = new Properties();
			FileInputStream doc = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\pbricks\\prop\\Config.properties");
			Config.load(doc);
			APP_LOGS.debug("Config file loaded sucessfully.");
			
			OR = new Properties();
			FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\pbricks\\prop\\OR.properties");
			OR.load(fil);
			APP_LOGS.debug("Loaded OR Property file succesfully.");
			
			//xls file
			APP_LOGS.debug("Initializing all excel files");
			PBSuiteXls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\pbricks\\xls\\PurpleBrickSuite.xlsx");
			SHPSuiteXls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\pbricks\\xls\\ShoppingSuite.xlsx");
			ADRSuiteXls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\pbricks\\xls\\AddressSuite.xlsx");
		    TestSuitesXls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\pbricks\\xls\\TestSuite.xlsx");
		    APP_LOGS.debug("Excel files sucessfully initialized.");
		   isInitialized = true;
		}
	
	} 
	
	

}
