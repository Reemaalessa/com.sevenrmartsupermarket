package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;

import dataproviders.DataProviders;

public class LoginwithDataproviders extends Base {
	
	LoginPage loginpage;
	
	
	@Test(dataProvider ="multilogin", dataProviderClass = DataProviders.class )
	
	public void verifyLoginWithDifferntAdminUsers(String userName, String Password) {
		loginpage = new LoginPage(driver);
		
		loginpage.login(userName, Password);
		
		
		
	}	
	

	
	
	

}