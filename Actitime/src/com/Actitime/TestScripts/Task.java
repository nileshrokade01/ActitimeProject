package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;
@Listeners(ListenerImplementation.class)
public class Task extends BaseClass {

	 
	@Test
	public void createCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(5000);
		HomePage hp = new HomePage(driver);
		hp.getTask().click();
		
		TaskPage t = new TaskPage(driver);
		t.getAddbtn().click();
		t.getNewcustomr().click();
		FileLibrary fl = new FileLibrary();
		String CreateCustomer = fl.readTheDataFromExcelSheet("Sheet1",6 , 1);
	   	String value = fl.readTheDataFromExcelSheet("Sheet1", 6, 2);
		t.getEncustname().sendKeys(CreateCustomer);
		String Actualresult = CreateCustomer;
		Thread.sleep(5000);
		
		t.getEncusdescptn().sendKeys(value);
		t.getCreatecust().click();
		t.getCancelbtn().click();
		String Expectedresult = driver.findElement(By.xpath("(//div[.='"+CreateCustomer+"'])[2]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Actualresult, Expectedresult);
		sa.assertAll();
		
		
	}
}
