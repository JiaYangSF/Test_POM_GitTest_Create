package com.myTest.facebook.pages.inbox;

import com.myTest.facebook.base.Page;

public class MyProfilePage extends Page{
	
	public void changePic(String newPicPath){
		click("changePic");
		input("uploadPhoto", newPicPath);

	}
	
	public FriendList loadFriendList(){
		click("Friends");
		return new FriendList();
	}

}
