package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.myTest.facebook.base.Page;
import com.myTest.facebook.pages.inbox.FriendList;
import com.myTest.facebook.pages.inbox.LandingPage;
import com.myTest.facebook.pages.inbox.MyProfilePage;
import com.myTest.facebook.pages.login.LoginPage;

public class Login {

	public static void main(String[] args) {
		
		
		LoginPage loginPage=new LoginPage();
		LandingPage landingPage=loginPage.doLogin("23425195@qq.com", "sandy2008");
		
		
		
		
		MyProfilePage myProfilePage=landingPage.goToProfile();
		//myProfilePage.changePic("C:\\Users\\IPL\\Desktop\\image2.jpg");
		FriendList friendList=myProfilePage.loadFriendList();
		boolean r=friendList.searchFriend("Grace Hou");
		System.out.println(r);
		
		
		
		//l.doLogin(userName, password)

	}

}
