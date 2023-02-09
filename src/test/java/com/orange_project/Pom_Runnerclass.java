package com.orange_project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pom_Runnerclass extends Orange_BaseClass {
	
	WebDriver driver = null;
	public static String finalUserId = "";
	public static String finalPassword = "";
	public static String userName , userCompare ,password1;
	
	@BeforeClass
	private static ChromeOptions desiredOptions() {
		List<String> listOfOptions = new ArrayList<String>();
		listOfOptions.add("start-maximized");
		ChromeOptions options = new ChromeOptions();
		options.addArguments(listOfOptions);
		System.out.println("passed1");
		return options;
	}
	@Test(priority=0)
	private void browserLaunch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(desiredOptions()); // Parameter pass
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sleep();
		System.out.println("passed2");
	}
	@Test(priority=1)
	public  void getUserId() throws InterruptedException {
		POM_Homeclass pm = new POM_Homeclass(driver);
		
		WebElement userId = pm.getUserId();
		  userName = get_Text(userId);
		System.out.println("Initial user Name="+userName);
		String[] id = userName.split(" ");

		for(int i = 2;i<id.length;i++)
		{
			System.out.println("id[i]=" + id[i]);

			finalUserId = finalUserId + id[i];
			System.out.println("Final User ID="+ finalUserId);
			sleep();
		}}
		
		
	@Test(priority=2)
		public void getPassword() throws InterruptedException {
		
		POM_Homeclass pm = new POM_Homeclass(driver);
		WebElement password = pm.getPassword();
		password1 = get_Text(password);
		System.out.println(password1);

		String[] pas = password1.split(" ");
		sleep();
		for(int i = 2;i<pas.length;i++)
		{
			System.out.println("pass[i]=" + pas[i]);

			finalPassword = finalPassword + pas[i];

		}	sleep();
		
		System.out.println("Final Password="+finalPassword);}
	
	@Test(priority = 3)
	private void passingUserId() throws InterruptedException {

		POM_Homeclass pm = new POM_Homeclass(driver);
	WebElement userLast = pm.getUserLast();
	userCompare = userLast.getAttribute("placeholder");
	System.out.println();
		System.out.println("User Compare="+userCompare);
		sleep();
		System.out.println("U.Name="+userName+" & "+"U.Compare ="+userCompare);
	if(userName.contains(userCompare))
	{
		WebElement userFinish = driver.findElement(By.xpath("//input[@name='username']"));
	
		sleep();
		sendKeys(userFinish,finalUserId );
		System.out.println("User Id Passed");
	}}
	@Test(priority = 4)
	private void passPassword() throws InterruptedException {

		POM_Homeclass pm = new POM_Homeclass(driver);
	WebElement passLast = pm.getPassLast();
	String passCompare = passLast.getAttribute("placeholder");

	if(password1.contains(passCompare))
	{
		WebElement passFinish = driver.findElement(By.xpath("//input[@name='password']"));
		sleep();
		sendKeys(passFinish, finalPassword);
		System.out.println("Password Passed");
		
	}
	}	
	@AfterClass
	private void submit() throws InterruptedException {

		POM_Homeclass pm = new POM_Homeclass(driver);
	WebElement findElementclick = pm.getFindElementclick();
	clickOnElement(findElementclick);
	
	sleep();
	driver.close();
	
	}

	

	}

	

	


