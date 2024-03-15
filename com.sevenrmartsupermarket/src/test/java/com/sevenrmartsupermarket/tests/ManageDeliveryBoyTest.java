package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.Excel;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage login;
	HomePage homepage;
	ManageDeliveryBoyPage managedeliveryboy;
	Excel excel = new Excel();

	@Test(groups = "regression")

	public void VerifyDeliveryboyDetailCreatedSuccesfully() {
		login = new LoginPage(driver);
		login.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManagedeliveryboy();
		managedeliveryboy = new ManageDeliveryBoyPage(driver);
		
		managedeliveryboy.enterdeliveryboyinfo("Ammala", "Ammala@gmail.com", "7889654", "mainstreet,add2,CA", "u",
				"Ami3i4");

		String Expected_message = "×\nAlert!\nDelivery Boy Details Created Successfully";
		String actual_message = managedeliveryboy.getsucsefullmessagetxt();

		Assert.assertEquals(actual_message, Expected_message);

	}

	@Test(groups = "smoke")

	public void addDeliveryboydetailfromExcel() {
		login = new LoginPage(driver);
		login.logIn();
		homepage = new HomePage(driver);
		homepage.clickOnManagedeliveryboy();
		managedeliveryboy = new ManageDeliveryBoyPage(driver);
		excel.setExcelFile("ManageDeliveryBoy", "DeliveyBoyDetails");
		managedeliveryboy.enterdeliveryboyinfo(excel.getCellData(1, 0) + "_" + managedeliveryboy.getTimestamp(),
				(excel.getCellData(1, 1)), excel.getCellData(1, 2), excel.getCellData(1, 3),
				excel.getCellData(1, 4) + "_" + managedeliveryboy.getTimestamp(), excel.getCellData(1, 5));
		String Expected_message = "x\nAlert!\nDelivery Boy Details Created Successfully";
		String actual_message = managedeliveryboy.getsucsefullmessagetxt();
		Assert.assertEquals(actual_message, Expected_message);

	}

}
