
package com.myTest.util;

import java.util.Hashtable;

public class TestUtil {

	// check the run mode in Test Case Sheet
	public static boolean isExecutable(String testName, Xls_Reader xls) {

		for (int rNum = 2; rNum <= xls.getRowCount("Test Cases"); rNum++) {
			if (testName.equals(xls.getCellData("Test Cases", "TCID", rNum))) {
				if (xls.getCellData("Test Cases", "Runmode", rNum).equals("Y"))
					return true;
				else
					return false;
			}
		}
		// if running out of for loop and not find, then:
		return false;
	}
	
	
	
	public static Object[][] getData(String testName, Xls_Reader xls){ // need test name and return the data corresponding to that test
		System.out.println("***********************");
		// find the test in the xlsx file "Test Data" sheet
		// find the number of col in the test
		// find the number of rows in the test
		// print the data of the test
		// put the data in object array
		
		
		// Step1: find the test in the xlsx file "Test Data" sheet
		int testCaseStartIndex=0;
		for(int rNum=1;rNum<=xls.getRowCount("Test Data"); rNum++){
			if(testName.equals(xls.getCellData("Test Data", 0, rNum))){
				testCaseStartIndex=rNum;
				break;
			}
		}
		
		System.out.println("Test starts from --"+testCaseStartIndex);
		
		
		// Step 2: find the number of col in the test		
		int colStartIndex=testCaseStartIndex+1;
		int cols=0;	
		while(!xls.getCellData("Test Data", cols, colStartIndex).equals("")) {
			cols++;
		}
		System.out.println("Total cols are --"+cols);
			
		
		
		
		// Step3: find the number of rows in the test
		int dataStartIndex=testCaseStartIndex+2;
		int rows=0;
		while(!xls.getCellData("Test Data", 0, (dataStartIndex+rows)).equals("")){
			rows++;
		}
		
		System.out.println("Total rows are --"+rows);
		
		
		// Step 4: put the data in object array
		Object[][] data=new Object[rows][1];
		Hashtable<String, String> table=null;
				
		// Step 4/5: print the data of the test
		for(int rNum=dataStartIndex; rNum<(dataStartIndex+rows); rNum++){// rows
			table=new Hashtable<String, String>();// every new row loop it will have a hashtable
			for(int cNum=0;cNum<cols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartIndex), xls.getCellData("Test Data", cNum, rNum));
				//System.out.print(xls.getCellData("Test Data", cNum, rNum)+"--");
			}
			//System.out.println("");
			// when the loop ends
			data[rNum-dataStartIndex][0]=table;// put the table in the object array//class 9
		}
	//System.out.println("--its good to run in debug mode");
		
		return data;	
		
	}
}
