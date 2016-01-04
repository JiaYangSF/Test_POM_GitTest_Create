package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.myTest.util.Xls_Reader;

public class ReadingExcel {

	public static void main(String[] args) {
		
		Xls_Reader xls_Reader=new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\myTest\\facebook\\xls\\TestCases");
		
		xls_Reader.getCellData("Test Cases", "Runmode", 2);
		

}
}