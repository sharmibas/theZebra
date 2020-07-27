package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Results {

	WebDriver driver;
	WebDriverWait wait;
	
	By resultHeader = By.xpath("//div[contains(@class,'main-content')]/div/h2");
	By quotes = By.xpath("//div[contains(@class,'carrier-cards')]");
	
	public boolean verifyResultsPage() throws InterruptedException {
		
		Thread.sleep(10000);
		
		return driver.findElement(resultHeader).isDisplayed();
		
	}
	
	public boolean verifyQuotesDisplayed() throws InterruptedException {
		
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(quotes)));
		
		return driver.findElement(quotes).isDisplayed();
		
	}
	
	public Results(WebDriver driver) {
		this.driver = driver;
	}
	
}
