package com.myTest.facebook.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.myTest.facebook.base.Page;
import com.myTest.facebook.pages.inbox.LandingPage;
import com.myTest.facebook.pages.inbox.MyProfilePage;
import com.myTest.facebook.pages.login.LoginPage;
import com.myTest.util.TestUtil;

public class ChangePicTest {

	@Test
	public void changePic() {
		// check run mode, this is the way to skip test
		if (!TestUtil.isExecutable("LoginTest", Page.xls_Reader))
			throw new SkipException("Run mode set to No");
		LandingPage landingPage = null;

		// login
		if (!Page.isLoggedIn) {// if checked not logged in, then create obj and
								// loigin
			LoginPage loginPage = new LoginPage();
			landingPage = loginPage.doLogin();
		} else {
			// I am loggin in
			landingPage=Page.topManu.goToLandingPage();
		}
		
		//go to profile and change pic
		MyProfilePage myProfile=landingPage.goToProfile();
		myProfile.changePic("C\\ new pic path");
		
		
	}

}
