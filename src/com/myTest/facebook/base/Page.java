package com.myTest.facebook.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.myTest.facebook.pages.inbox.TopManu;
import com.myTest.util.Xls_Reader;

public class Page {

	// keep below encapsulated
	public static WebDriver driver = null;
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static TopManu topManu=null;
	public static Xls_Reader xls_Reader=new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\myTest\\facebook\\xls\\TestCases.xlsx");
	public static boolean isLoggedIn=false;
	
	// using Page constructor to initiate browser, landing page with property
	// file
	public Page() {
		if (driver == null) {
			CONFIG = new Properties();
			OR=new Properties();

			try {
				
				//CONFIG
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\com\\myTest\\config\\config.properties");
				CONFIG.load(fs);
				
				// OR
				fs = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\com\\myTest\\config\\OR.properties");
				OR.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// error
				return;
			}

			if (CONFIG.getProperty("browser").equals("Mozilla")) {
				this.driver = new FirefoxDriver();
			} else if (CONFIG.getProperty("browser").equals("IE")) {
				System.setProperty("webdriver.chorme.driver", "C:\\Users\\IPL\\Desktop\\Jia\\BrowserDrivers");
				this.driver = new ChromeDriver();
			} else if (CONFIG.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\IPL\\Desktop\\Jia\\IEDriverServer");
				this.driver = new InternetExplorerDriver();
			}
			
			// implicitly wait for the whole application
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			topManu=new TopManu();

		}
	}
	
	// then make methods
	
	public void click(String xpathKey){
		// if error, report here
		
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Click Error");
			
		}
	}
	
	 public void clickLink(String linkText){
		// if error, report here
		
		try{
			driver.findElement(By.linkText(OR.getProperty(linkText))).click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Click Link Error");
			
		}
	}
	
	public void input(String xpathKey, String text){
		// if error, report here
		
		try{
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(text);
		}catch(Exception e){
			// report error
		}
	}
	
	public boolean isElementPresent(String xpathKey){
		try {driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		} catch (Exception e){
			return false;
		}
		
		return true;}
	
	
	// to find the link
	public boolean isLinkPresent(String linkText){
		try {driver.findElement(By.linkText(OR.getProperty(linkText)));
		} catch (Exception e){
			return false;
		}
		
		return true;}

	public static void takeScreenshot(String fileName) {
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// take pic as 10101 format, not jpg format
		
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
