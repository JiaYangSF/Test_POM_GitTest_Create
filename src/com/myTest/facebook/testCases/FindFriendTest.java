package com.myTest.facebook.testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.myTest.facebook.base.Page;
import com.myTest.facebook.pages.inbox.FriendList;
import com.myTest.facebook.pages.inbox.LandingPage;
import com.myTest.facebook.pages.inbox.MyProfilePage;
import com.myTest.facebook.pages.login.LoginPage;
import com.myTest.util.TestUtil;

public class FindFriendTest {
	
	@Test
	public void findFriend() {
		String friendName="Grace Hou";
		// check run mode, this is the way to skip test
		if (!TestUtil.isExecutable("FindaFriendTest", Page.xls_Reader))
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
		
		MyProfilePage myProfilePage=landingPage.goToProfile();
		FriendList flist=myProfilePage.loadFriendList();
		//flist.searchFriend(friendName);
		Assert.assertTrue(flist.searchFriend(friendName), friendName+"--Friend not found");

}
	
	@Test(dependsOnMethods = { "findFriend" })
	public void messageFriend(){
		System.out.println("messageFriend");

	}
}
