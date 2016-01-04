package com.myTest.facebook.pages.inbox;

import com.myTest.facebook.base.Page;

public class FriendList extends Page {
	
	
	public boolean searchFriend(String friendName){
		input("friend_Name_Search", friendName);
		return isLinkPresent(friendName);
	}
	
	
	
	
	
	

}
