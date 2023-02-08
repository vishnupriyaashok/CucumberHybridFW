package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
/*
 * this method is used ti initialize the threadlocal driver on the basis of given browser
 * @param:String browser
 * @return:WebDriver
 */
	public WebDriver init_Driver(String browser) {
		System.out.println("browser value is :" + browser);
		if (browser.equalsIgnoreCase(Constants.CHROME_BROWSER_VALUE)) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER_VALUE)) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase(Constants.SAFARI_BROWSER_VALUE)) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("please pass the right browser");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	/*
	 * this method is used to get driver with Threadlocal
	 * return: WebDriver
	 */

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
