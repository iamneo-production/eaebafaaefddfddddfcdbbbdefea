package com.examly.springapp;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Assignment1 {

	// Creating an instance of Firefox Browser
	FirefoxDriver driver;
	String  iamneoUrl = "http://iamneo.ai";
	String facebookUrl = "https://www.facebook.com";

	@Test(priority=0)
	public void invokeBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get( iamneoUrl);

		String titleOfThePage = driver.getTitle();
		
		Assert.assertEquals(titleOfThePage, "We are Hiring!");

	}

	@Test(priority= 1)
	public void navigateCommands() {
		driver.navigate().to(facebookUrl);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL :: " + currentUrl);
		driver.navigate().back();

		driver.navigate().forward();

		driver.navigate().refresh();

                driver.quit();
	}

}