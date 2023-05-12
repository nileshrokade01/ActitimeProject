package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// POM : page object model

public class LoginPage {

	//Declaration	
	@FindBy(name = "username")
	private WebElement untb;
	
	@FindBy(name = "pwd")
	private WebElement pwtb;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lgbtn;
	
 //initization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
 //Utilization
	    public WebElement getUntb() {
			return untb;
		}

		public WebElement getPwtb() {
			return pwtb;
		}

		public WebElement getLgbtn() {
			return lgbtn;
		}

 
}

