package test;

import com.myTest.util.TestUtil;
import com.myTest.util.Xls_Reader;

public class Test_MyData {

	public static void main(String[] args) {
		TestUtil.getData("LoginTest", new Xls_Reader((System.getProperty("user.dir"))+"//src//com\\myTest\\facebook\\xls\\TestCases.xlsx"));
		TestUtil.getData("ChangePicTest", new Xls_Reader((System.getProperty("user.dir"))+"//src//com\\myTest\\facebook\\xls\\TestCases.xlsx"));
		TestUtil.getData("FindaFriendTest", new Xls_Reader((System.getProperty("user.dir"))+"//src//com\\myTest\\facebook\\xls\\TestCases.xlsx"));

	}

}
