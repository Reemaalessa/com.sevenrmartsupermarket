package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	Select select;
	Actions action;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void select_Index(WebElement element, int intex) {
		select = new Select(element);
		select.selectByIndex(intex);
	}

	public void select_byvisibletext(WebElement element, String Visibletext) {
		select = new Select(element);
		select.selectByVisibleText(Visibletext);
	}

	public void mouse_move(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
