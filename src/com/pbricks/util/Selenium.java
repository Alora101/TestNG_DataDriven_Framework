package com.pbricks.util;

import java.util.Hashtable;

import org.apache.log4j.Logger;


public class Selenium {
	
	public static Logger APP_LOGS  = null;
	
	public static boolean IsSuiteRunnable(Xls_Reader xls , String SuiteName, String SheetName, String ColName1 , String ColName2)
	{
	 boolean isExecutable = false;
	 for(int i = 2; i <= xls.getRowCount(SheetName); i++)
	{
	 String Suite = xls.getCellData(SheetName,ColName1, i);
	 String RunMode = xls.getCellData(SheetName, ColName2, i);
	// System.out.println(Suite +"---" + RunMode);

	  if(Suite.equalsIgnoreCase(SuiteName)){
	      if(RunMode.equalsIgnoreCase("Y")){
	      isExecutable = true;
	    // System.out.println(SuiteName + ":" + "I am executable.");
	    }else
	      {
	       isExecutable = false;
	    //    System.out.println(SuiteName + ":" + "Unexecutable.");
	      }
	   }
	}
	xls = null; // release memory.
	return isExecutable;
	}
	

	
	public static boolean isTestCaseRunnable(Xls_Reader xls , String SheetName , String ColName1 ,String ColName2 ,String TestCaseName)
	{
	  boolean isExecutable = false;
	  for(int i = 2 ; i <= xls.getRowCount(SheetName); i++)
	  {
	    String TestName = xls.getCellData(SheetName , ColName1 , i);
	    String RunMode = xls.getCellData(SheetName, ColName2, i);
	  //  System.out.println(TestName + "----" + RunMode);

	     if(TestName.equalsIgnoreCase(TestCaseName)){
	        if(RunMode.equalsIgnoreCase("Y")){
	        isExecutable = true;
	       //  System.out.println();
	   }else{
	       isExecutable = false;
	    //  System.out.println(TestCaseName + ":" + "Unexecutable.");
	     }
	  }  
	}
	xls = null; //release memory.
	return isExecutable;
	}
	
	
	public static Object[][] getData(String sheetName,String testCase, Xls_Reader xls)
	{   
	//Things to be considered - 

	//row num on which the testcase name supplied starts from.
	//Total number of rows of data for testcase
	// cols
	//extract data
		

	//This get the row number the testcase name supplied starts from.
	int testStartRowNum = 1;
	while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCase))
	{
	 testStartRowNum++;
	}
	//This is just to comment out the row number where test is.
	System.out.println("Test case "+testCase+" starts from row " + testStartRowNum);


	//Total number of  rows of data for testcase: Data will start 2rows down the testcase name starts from hence +2.

	int dataStartRowNum = testStartRowNum+2;
	int rows=0;
	while(!xls.getCellData(sheetName,0,dataStartRowNum+rows).equals(""))   //This iterates through the data sheet until a space is found.
	{
	   rows++;
	}
	System.out.println("The total number of test data for "+testCase+" are " + rows);  //This will comment out number of datarows for specified testCase.


	//Total Column number for testcase: Column will start 1row down the testcase name start from hence +1.
	int TotalColNum = testStartRowNum+1;
	int cols = 0;
	while(!xls.getCellData(sheetName,cols,TotalColNum).equals(""))
	{
	  cols++;
	}
	System.out.println("Total number of cols in test case "+testCase+" are " + cols);      //This will comment the number of columns for testcase.

	Object testData[][] = new Object[rows][1];
	int index=0;
	Hashtable <String, String> table = null;


	//Extract data for the test case
	for(int rNum = dataStartRowNum; rNum < dataStartRowNum+rows; rNum++)
	 {
	     table = new Hashtable<String,String>();   //table gets initialised for every row.
	     for(int cNum=0; cNum < cols; cNum++){
	         String key = xls.getCellData(sheetName, cNum,TotalColNum);
	         String value = xls.getCellData(sheetName , cNum , rNum);
	        System.out.print(value + "---");       //This must return all the data for a particular test.
	  
	       //Now let fill the table
	       table.put(key,value);       
	      }
	      System.out.println("");
	      testData[index][0] = table;
	      index++;
	 }

	System.out.println("***********************************************************");
	return testData;

	   }
  }

