package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class topMenu {
	


	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("23425195@qq.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("sandy2008");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
		
		// log out
		//driver.findElement(By.xpath("//div[@class='uiScrollableAreaContent']/ul/li[17]")).click();

		driver.findElement(By.linkText("Log Out")).click();
	}

}
