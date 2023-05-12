package com.Actitime.GenericLibrary;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerImplementation.class)
public class Nilesh extends BaseClass {

	@Test
	public void actiFail() {
		Assert.fail();
	}
}
