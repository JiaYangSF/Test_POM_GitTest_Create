package com.myTest.facebook.pages.inbox;

import org.openqa.selenium.WebDriver;

import com.myTest.facebook.base.Page;

public class LandingPage extends Page{

	public MyProfilePage goToProfile(){
		click("go_To_Profile");
		return new MyProfilePage();
		
	}
}
