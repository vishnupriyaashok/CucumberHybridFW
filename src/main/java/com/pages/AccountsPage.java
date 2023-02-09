package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;

	private By accountSideList = By.xpath("//aside[@id='column-right']//a");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}

	public int accountSectionCount() {
		return driver.findElements(accountSideList).size();
	}

	public List<String> accountPageSectionList() {
		List<WebElement> secList = driver.findElements(accountSideList);
		List<String> sectionList = new ArrayList<>();
		for (WebElement e : secList) {
			String text = e.getText();
			sectionList.add(text);
		}
		return sectionList;

	}

}
