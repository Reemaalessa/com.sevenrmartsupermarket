package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.Excel;

public class PushNotificationsTest extends Base {
	LoginPage login;
	HomePage homepage;
	PushNotificationsPage pushnotification;
	Excel excel = new Excel();

	@Test(groups = { "smoke", "regression" })

	public void verifyenterNotifications() {
		{
			login = new LoginPage(driver);
			login.login("Amina", "B000A0GB7Q");
			homepage = new HomePage(driver);
			homepage.clickOnPushNotificationLink();
			pushnotification = new PushNotificationsPage(driver);
			pushnotification.sendNotifications("Hi", " hello");
			pushnotification.sucessfullMessage();
		}
	}

	@Test
	public void verifyPushNotifications() {
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		pushnotification = new PushNotificationsPage(driver);
		login.logIn();
		homepage.clickOnPushNotificationLink();
		excel.setExcelFile("PushNotifications", "Notifications");
		pushnotification.sendNotifications(excel.getCellData(0, 0), excel.getCellData(0, 1));
		boolean exp_successmsg = true;
		boolean act_successmsg = pushnotification.visibilityOfSuccessMessageBox();
		Assert.assertEquals(act_successmsg, exp_successmsg);
	}
	// String act_successmsgbox = pushnotification.alertMessageGetText();
	// System.out.println(act_successmsgbox);

	@Test
	public void verifyResetButtonFunctionality() {
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		pushnotification = new PushNotificationsPage(driver);
		login.logIn();
		homepage.clickOnPushNotificationLink();
		excel.setExcelFile("PushNotifications", "Notifications");
		pushnotification.resetNotifications(excel.getCellData(0, 0), excel.getCellData(0, 1));
//			boolean exp_successmsgbox = true;
//			boolean act_successmsgbox = pushnotification.visibilityOfSuccessMessageBox();
//			Assert.assertEquals(act_successmsgbox, exp_successmsgbox);
	}

	@Test

	public void printExcelData() {
		excel.setExcelFile("LoginData", "LoginCredntls");
		System.out.println(excel.getCellData(0, 0));
		System.out.println(excel.getCellData(0, 1));
	}
}