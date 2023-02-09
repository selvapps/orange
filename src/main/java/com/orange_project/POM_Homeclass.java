package com.orange_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Homeclass {
	public static WebDriver driver;
	//WebElement userId = driver.findElement(By.xpath("//p[text()='Username : Admin']"));
//	WebElement password = driver.findElement(By.xpath("//p[text()='Password : admin123']"));
//	WebElement userLast = driver.findElement(By.xpath("//input[@placeholder='Username']"));
//	WebElement passLast = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	//WebElement findElementclick = driver.findElement(By.xpath("//button[text()=' Login ']"));
	
	
	@FindBy(xpath="//p[text()='Username : Admin']")
	private WebElement userId;
	
	public POM_Homeclass(WebDriver driver2) {
  this.driver=driver2;
	PageFactory.initElements(driver, this);
	
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getUserLast() {
		return userLast;
	}

	public WebElement getPassLast() {
		return passLast;
	}

	public WebElement getFindElementclick() {
		return findElementclick;
	}

	@FindBy(xpath="//p[text()='Password : admin123']")
	private WebElement password;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userLast;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passLast;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement findElementclick;
	
	
	
	
	
	
	
	
	
	
}
