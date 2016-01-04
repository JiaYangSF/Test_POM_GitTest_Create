package com.myTest.facebook.testCases;

import java.util.Hashtable;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myTest.facebook.base.Page;
import com.myTest.facebook.pages.inbox.LandingPage;
import com.myTest.facebook.pages.login.LoginPage;
import com.myTest.util.TestUtil;
import com.myTest.util.ErrorUtil;

public class LoginTest {

	@Test(dataProvider = "getData")
	public void login(Hashtable<String, String> data) {// avoid creation of
														// multiple variable, no
														// need to String
														// username, String
														// password etc.

		// check run mode for test case, this is the way to skip test
		if (!TestUtil.isExecutable("LoginTest", Page.xls_Reader))
			throw new SkipException("Run mode set to No");

		// check run mode for Data set, this is the way to skip test
		if (!data.get("Runmode").equals("Y"))
			throw new SkipException("Run mode set to No for the data set");

		System.out.println(data.get("Runmode") + "--" + data.get("Username") + "--" + data.get("Password"));

		// log out if logged in
		if (Page.isLoggedIn) {
			Page.topManu.Logout();
			Page.isLoggedIn = false;
		}

		String testDataType = data.get("Flag");
		LoginPage loginPage = new LoginPage();
		LandingPage landingPage = loginPage.doLogin(data.get("Username"), data.get("Password"));

		// error
		if (landingPage == null & testDataType.equals("Y")) { // if test data is
																// true and
																// landing page
																// is there,
																// then error,
																// not able to
																// login
			try {
				Assert.assertTrue("Not able to login with correct data ",false);
			} catch (Throwable t) {
				Page.takeScreenshot("Login");
				ErrorUtil.addVerificationFailure(t);
			}
			Page.isLoggedIn = false;
			return;
		} else if (landingPage != null & !testDataType.equals("Y")) {
			Assert.assertTrue("Able to login with incorrect data ",false);
			Page.isLoggedIn = false;
			return;
		}

		if (testDataType.equals("Y"))
			Page.isLoggedIn = true;
		else
			Page.isLoggedIn = false;

	}

	@DataProvider
	public Object[][] getData() {
		return TestUtil.getData("LoginTest", Page.xls_Reader);
	}

}
