package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	//declaration	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement task;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement report;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement users;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutlink;
	
 //initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
 //Utilization
	public WebElement getTask() {
		return task;
	}
	public WebElement getReport() {
		return report;
	}

	public WebElement getUsers() {
		return users;
	}
	public WebElement getLogoutlink() {
		return logoutlink;
	}


}
