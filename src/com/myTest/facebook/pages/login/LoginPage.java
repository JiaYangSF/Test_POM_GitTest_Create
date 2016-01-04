package com.myTest.facebook.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.myTest.facebook.base.Page;
import com.myTest.facebook.pages.inbox.LandingPage;
import com.myTest.util.ErrorUtil;

public class LoginPage extends Page {
	// null - if login is not success
	// LandingPage - if login is success
	
	public LandingPage doLogin(String userName, String password) {
	
		try{
			Assert.assertEquals("XXXWelcome to Facebook — Log in, sign up or learn more", driver.getTitle());
			}catch(Throwable t){
			 Page.takeScreenshot("Login.jpg"); // get screenshot on error, need to know how to delete
			}
		
		
		
		driver.get(CONFIG.getProperty("testSiteLadingPageURL"));
		System.out.println(isElementPresent("//input[@id='email']"));
		input("Email", userName);
		input("Password", password);
		click("Login_Button");
		
	

		if (isElementPresent("go_To_Profile")) {
			return new LandingPage();
		} else {
			return null;
		}
		
		

	}

	public LandingPage doLogin() {
		
		return doLogin(CONFIG.getProperty("defaultUserName"), CONFIG.getProperty("defaultPassword"));
	}

	public void register() {

	}

}
