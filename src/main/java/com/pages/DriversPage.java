package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriversPage {
	
	WebDriver driver;
	
	By email = By.xpath("//input[contains(@id,'email')]");
	By dropDown = By.id("dropdown-select-wrap ");
	By showQuotes = By.xpath("//button[contains(@id,'ShowQuotesBtn')]");
	By hearAbout = By.xpath("//div[contains(@class,'question-dropdown')]/div");

	public void selectGender(String input) throws InterruptedException {
		Thread.sleep(2000);
		String genderSelection = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement gender = driver.findElement(By.xpath(genderSelection));
		gender.click();
		
	}
	
	public void selectMartialStatus(String input) throws InterruptedException {
		Thread.sleep(1000);
		String martialStatus = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement martial = driver.findElement(By.xpath(martialStatus));
		martial.click();
	}
	
	public void selectCreditScore(String input) throws InterruptedException {
		Thread.sleep(1000);
		String creditScore = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement credit = driver.findElement(By.xpath(creditScore));
		credit.click();
	}
	
	public void selectEducation(String input) throws InterruptedException {
		Thread.sleep(1000);
		String education = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement higherEducation = driver.findElement(By.xpath(education));
		higherEducation.click();
	}
	
	
	public void violationsSelect(String input) throws InterruptedException {
		Thread.sleep(1000);
		String selectViolation = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement accident = driver.findElement(By.xpath(selectViolation));
		accident.click();
	}
	
	public void enterEmailId(String input) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(email).sendKeys(input);
		
	}
	
	public void selectDiscounts(List<String> input) throws InterruptedException {
		Thread.sleep(1000);
		for(int i=0; i<input.size(); i++) {
		
			String selectDiscount = "//label[contains(@data-cy,'"+input.get(i)+"')]";
			WebElement discount = driver.findElement(By.xpath(selectDiscount));
			discount.click();
		}
	}
	
	public void hearAbout(String input) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(hearAbout).click();
		
		String source = "//div[contains(@id,'"+input+"')]";
		
		WebElement selectSource = driver.findElement(By.xpath(source));
		selectSource.click();
		
	}
	
	public void addDriver(String input) throws InterruptedException {
		Thread.sleep(1000);
		String addDriver = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement driverOption = driver.findElement(By.xpath(addDriver));
		driverOption.click();
		
	}
	
	public Results showQuotes() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(showQuotes).click();
		
		Results resultPage = new Results(driver);
		return resultPage;
		
	}
	
	public DriversPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
