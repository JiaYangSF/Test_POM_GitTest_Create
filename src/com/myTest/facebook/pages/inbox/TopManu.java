package com.myTest.facebook.pages.inbox;

import org.eclipse.jdt.internal.compiler.ast.OR_OR_Expression;
import org.openqa.selenium.By;

import com.myTest.facebook.base.Page;

public class TopManu {

	public void Logout() {

		Page.driver.findElement(By.xpath(Page.OR.getProperty("TopManu_DropdownLink"))).click();
		Page.driver.findElement(By.linkText(Page.OR.getProperty("TopManu_LogOut"))).click();
	}

	public void search(String searchText) {

	}

	public LandingPage goToLandingPage() {
		Page.driver.findElement(By.xpath(Page.OR.getProperty("LandingPageFBLogoLink"))).click();
		return new LandingPage();

	}

}
