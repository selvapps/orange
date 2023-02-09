package com.orange_project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orange_testNg   {

	
	WebDriver driver = null;

	private static List<String> listofOptions() {
		List<String> listOptions = new ArrayList<>();
		listOptions.add("start-maximized");
		return listOptions;
	}

	@BeforeTest
	public void browser_Launch() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments(listofOptions());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	}

	@Test(priority = 0)
	public void url_Launch() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	// user name and password
	public void login() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//div/p[text()='Username : Admin']"));
		String name = username.getText();
//		System.out.println("*****name::"+name);
		String usernamelogin = "";
		String userpassword = "";
		System.out.println(name);
		String[] split = name.split(":");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			if (i == 1) {

				System.out.println("******" + split[i]);
				usernamelogin = usernamelogin + split[i].replaceAll(" ", "");
			}
		}
		System.out.println("login user name:" + usernamelogin);
		
		
		//password
		WebElement pass = driver.findElement(By.xpath("//div/p[text()='Password : admin123']"));
		String password = pass.getText();
		System.out.println("*******password::"+password);
	
		System.out.println(password);
		String[] split1 = password.split(":");
		for (int i = 0; i < split1.length; i++) {
			System.out.println(split1[i]);
			if (i == 1) {

				System.out.println("******" + split1[i]);
				userpassword = userpassword + split1[i].replaceAll(" ", "");
			}
		}
		System.out.println("login password:" + userpassword);
		
		Thread.sleep(3000);
		
		
			WebElement userinput = driver.findElement(By.xpath("//input[@name='username']"));	
			String attributename1 = userinput.getAttribute("placeholder");
			System.out.println("attributename1:"+attributename1);
			if(name.contains(attributename1)) {
					userinput.sendKeys(usernamelogin);
			}
		
		
		
			WebElement userpass = driver.findElement(By.xpath("//input[@type='password']"));
			String attributepass1 = userpass.getAttribute("placeholder");
			System.out.println("attributepass1:"+attributepass1);
			
			if(password.contains(attributepass1)) {
		
			userpass.sendKeys(userpassword);

			
		}
		
			Thread.sleep(3000);
//			
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		driver.close();
	}
		

	}

	

	
	
	
	

