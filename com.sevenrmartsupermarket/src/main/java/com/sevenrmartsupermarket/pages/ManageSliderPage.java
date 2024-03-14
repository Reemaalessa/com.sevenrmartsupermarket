package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageSliderPage {

	WebDriver driver;
	
	Properties properties = new Properties();
	PageUtility pageUtility = new PageUtility(driver);
	
	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//p[text()='Manage Slider']")
	WebElement manageSlider;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]//span")
	WebElement checkStatusActive;
	
	public void VerifyClickManageSlider() {
		manageSlider.click();
		
	}
	
	public boolean VerifyCheckStatusActive() {
		
		System.out.println(checkStatusActive.isDisplayed());
		return checkStatusActive.isDisplayed();
	}
	
	
}
