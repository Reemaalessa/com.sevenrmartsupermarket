package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageSliderPage;

public class ManageSliderTest extends Base {
	
	
	LoginPage login;
	HomePage homepage;
	ManageSliderPage manageSliderPage;
	
	@Test
	
	public void VerifyManageSliderInfo() {
		
		login = new LoginPage(driver);
		login.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		manageSliderPage = new ManageSliderPage(driver);
		manageSliderPage.VerifyClickManageSlider();
		manageSliderPage.VerifyCheckStatusActive();		
		boolean actual_result= manageSliderPage.VerifyCheckStatusActive();
		boolean expected_result= true;
		//SoftAssert s = new SoftAssert();
		Assert.assertEquals(actual_result, expected_result);
		//s.assertAll();
	}
}
