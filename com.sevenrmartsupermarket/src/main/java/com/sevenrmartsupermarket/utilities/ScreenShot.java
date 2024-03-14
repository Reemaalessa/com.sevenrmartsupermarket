package com.sevenrmartsupermarket.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenShot {

	static TakesScreenshot screenshot; // interface

	public static void takeScreenShot(WebDriver driver, String imageName) {

		try {
			screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constants.SCREENSHOT_FILE_PATH + imageName + "_" + timeStamp + ".png";
			File destination = new File(path);
			FileHandler.copy(file, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
