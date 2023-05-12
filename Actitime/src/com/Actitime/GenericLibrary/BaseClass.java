package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	FileLibrary f = new FileLibrary();
@BeforeSuite
public void dataBaseConnection() {
	Reporter.log("database connected successfully",true);
}

@BeforeClass
public void launchBrowser() throws IOException {
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String url =f.readingFromPropertyFile("url");
	driver.get(url);
	Reporter.log("browser is luanch",true);
}

@BeforeMethod
public void loginPre() throws IOException, InterruptedException {
	String un = f.readingFromPropertyFile("username");
	String pwd = f.readingFromPropertyFile("password");
	Thread.sleep(5000);
	LoginPage lp = new LoginPage(driver);
	lp.getUntb().sendKeys(un);
	lp.getPwtb().sendKeys(pwd);
	lp.getLgbtn().click();
	Reporter.log("login successfull",true);
}

@AfterMethod
public void logout() throws InterruptedException {
	Thread.sleep(5000);
	HomePage hp = new HomePage(driver);
	hp.getLogoutlink().click();
	Reporter.log("logged out successfully",true);
}

@AfterClass
public void closeBrowser() {
	driver.close();
	Reporter.log("browser is closed",true);
}

@AfterSuite
public void dataBaseDisconnection() {
	Reporter.log("database is disconnected",true);
}

/*
 * @Test public void successfull() {
 * Reporter.log("the above process is successfull",true); }
 */
}
