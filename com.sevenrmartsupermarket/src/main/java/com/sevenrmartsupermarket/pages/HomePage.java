package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private static final String manageexpensepage = null;
	WebDriver driver;
	@FindBy(xpath = "//div[@class='info']")
	WebElement profileName;

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotificationLink;

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	WebElement ManageDeliveryboy;

	@FindBy(xpath = "//li//a//p[contains(text(),'Manage Expense')]")
	WebElement manageexpense;
	
	@FindBy(xpath = "//a[@class=\"active nav-link\"]")
	WebElement select_expensecategory;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public void clickOnPushNotificationLink() {
		pushNotificationLink.click();
	}

	public void clickOnManagedeliveryboy() {
		ManageDeliveryboy.click();

	}

	public void clickOnManageExpensePage() {
		manageexpense.click();

	}
	public void selectExpenceCatergory() {
		select_expensecategory.click();
	}

	

}
