package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initializing browser **/
	public void initialize(String browser, String url) {  
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new EdgeDriver(options);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new FirefoxDriver(options);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();
		
	}

	@Parameters("browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) {

		// String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);
	}

	@BeforeMethod(enabled=true, alwaysRun = true)
	public void launchBrowser() {

		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);
	}

	@AfterMethod
	public void terminatSession(ITestResult itestresult) {

		if (itestresult.getStatus() == ITestResult.FAILURE) {

			ScreenShot.takeScreenShot(driver, itestresult.getName());
		}
	}
}
