package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageExpensePage {

	WebDriver driver;

	Properties properties = new Properties();
	PageUtility pageUtility = new PageUtility(driver);

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@ class='nav-icon fas fa-money-bill-alt']")
	WebElement manage_expense;

	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement select_expensecategory;

	@FindBy(xpath = "//h1[text()='Expense Category']")
	WebElement head_title;

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]//i")
	WebElement new_button;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement enterthe_title;

	@FindBy(xpath = "//button[@name=\"Create\"]")
	WebElement clickonsavebutton;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement successmessage;
	

	public void clickonmanageexpense() {
		manage_expense.click();
	}

	public void selectTheExpenseCategory() {
		select_expensecategory.click();
	}

	public String gethHeadTitleText() {
		return enterthe_title.getText();
	}

	public void newbuttonofmanageexpense() {
		new_button.click();
	}

	public String enterTitle(String title) {
		enterthe_title.sendKeys(title);
		System.out.println(title);
		return title;
	}

	public void clickOnSubmitButton() {
		clickonsavebutton.click();
	}
	public String  getsucsefullmessagetxt() {
		String  message=successmessage.getText().trim();
		System.out.println(message);
		return message;		
	}
		
	public void addnewCategoryInfo(String title) {
			newbuttonofmanageexpense();
			enterTitle(title);
			clickOnSubmitButton();
			
		}
}
	
	

