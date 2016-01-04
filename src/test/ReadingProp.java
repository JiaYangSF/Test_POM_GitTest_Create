package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProp {

	public static void main(String[] args) {
		// properties obj
		Properties prop=new Properties();
		// Path
		String path=System.getProperty("user.dir") +"\\src\\com\\myTest\\config\\config.properties";
		System.out.println(path);
		
		// connecting to the file--fileinputstream
		// load
		
		try {
			FileInputStream fs=new FileInputStream(path);
			prop.load(fs);
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
		

	}

}
