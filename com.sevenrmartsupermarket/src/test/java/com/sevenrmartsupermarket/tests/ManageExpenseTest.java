package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;
import com.sevenrmartsupermarket.utilities.Excel;

public class ManageExpenseTest extends Base {
	
	LoginPage login;
	HomePage homepage;
	ManageExpensePage manageexpensepage;
	Excel excel = new Excel();
	
	

	@Test
	
	public void VerifyManageExpensePage() {
		login = new LoginPage(driver);
		login.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		
		manageexpensepage = new ManageExpensePage(driver);;
		manageexpensepage.clickonmanageexpense();
		manageexpensepage.selectTheExpenseCategory();
		manageexpensepage.gethHeadTitleText();
		manageexpensepage.newbuttonofmanageexpense();
		manageexpensepage.enterTitle("title");
		manageexpensepage.clickOnSubmitButton();
		
		String expected_message = "×\nAlert!\nCategory already exists.";
		String actual_message = manageexpensepage.getsucsefullmessagetxt();
		Assert.assertEquals(actual_message, expected_message);
			
	}
	
//	public void VerifyexpenseCategoryAddedSuccesfully() {
//		login = new LoginPage(driver);
//		login.login("Amina", "B000A0GB7Q");
//		homepage = new HomePage(driver);
//		homepage.clickOnManageExpence();
//		homepage.clickOnManageExpenceoption();
//		expensecategory=new ExpenseCategoryPage (driver);
//		expensecategory.addnewCategoryInfo("apple");
//		String Expected_message = "×\nAlert!\nExpense Category Created Successfully"; 
//		String actual_message = expensecategory.getsucsefullmessagetxt();
//		Assert.assertEquals(actual_message, expected_message);


	@Test
	
	public void VerifyExcelData() {
		login = new LoginPage(driver);
		login.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);;
		manageexpensepage.clickonmanageexpense();
		manageexpensepage.selectTheExpenseCategory();
		manageexpensepage.gethHeadTitleText();
		manageexpensepage.newbuttonofmanageexpense();
//		manageexpensepage.enterTitle("title");
		excel.setExcelFile("ExpenseCategoryData", "ExpenseCategory");
		manageexpensepage.addnewCategoryInfo(excel.getCellData(3, 0));
	
}
	
}