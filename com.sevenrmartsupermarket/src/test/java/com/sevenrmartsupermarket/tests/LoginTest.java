package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base {
	LoginPage login;
	HomePage homepage;

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)

	public void verifyLogin() {

		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		login.login("abcd563814", "qwerty24");
		String expectedProfileName = "Abcd563814";
		String actualProfileName = homepage.getProfileName();

		System.out.println(GeneralUtility.getRandomFirstName());// randomfirstName

		Assert.assertEquals(actualProfileName, expectedProfileName);

		// listner ,its an inteface used to listen the test case , used to commmunicate
		// whether it is passs/ fail

		// ITestListener- testNG

	}

}
