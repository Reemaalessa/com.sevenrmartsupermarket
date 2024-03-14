package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@name='remember_me']")
	WebElement remeberMeCheckBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // POM using page factory

		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			Properties properties = new Properties();
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		passwordField.sendKeys(passWord);
	}

	public void clickOnSignIn() {
		loginButton.click();
	}
	public void login(String userName,String password) {
		
		enterUserName(userName);
		enterPassword(password);
		clickOnSignIn();
		
	}
	//method overloading
	public void logIn() {
		String userName = properties.getProperty("userName");
		String passWord = properties.getProperty("passWord");
		login(userName,passWord);
	}
}