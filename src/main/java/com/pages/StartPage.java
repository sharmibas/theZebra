package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse; 
	
	private String YesorNoInsurance;
	private String OwnOrRent;
	private String shoppingOptions;
	
	
	
	
	By residenceModule = By.id("residence_ownershipstart");
	
	By shoppingModule = By.id("user_intentstart");
	
	By enterDetailsModule = By.xpath("//div[contains(@id,'driverPIIstart')]");
	
	By saveButton = By.xpath("//button[contains(@id,'SaveBtn')]");
	
	By selectAddressFromOptions = By.xpath("//div[contains(@class,'pac-container')]/div[1]");
	
	By firstName = By.id("first_namestart");
	
	By lastName = By.id("last_namestart");
	
	By birthDate = By.id("date_of_birthstart");
	
	By parkingAddress = By.id("garaging_addressInput");
	
	
	public void waitForPageToLoad() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'start')]")));
	}
	
	public void selectInsuranceOption(String YesorNoInsurance) {
		
		String haveInsurance = "//label[contains(@data-cy,'"+YesorNoInsurance+"')]";
		
		By selectInsurance = By.xpath(haveInsurance);
		
		driver.findElement(selectInsurance).click();
		
	}
	
	public void selectWhatyouOwn(String OwnOrRent) {
		
		String ownOptions = "//label[contains(@data-cy,'"+OwnOrRent+"')]";
		
		 By selectOwnOptions = By.xpath(ownOptions);
		
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("residence_ownershipstart")));
		 
		 //scroll(driver.findElement(residenceModule));
		 
		 driver.findElement(selectOwnOptions).click();
		
	}
	
	public void selectShopping(String shoppingOptions) {
		
		String whyShoppingOptions = "//label[contains(@data-cy,'"+shoppingOptions+"')]";
		
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(whyShoppingOptions)));
		 
		 //scroll(driver.findElement(shoppingModule));
		 
		 By selectShoppingOptions = By.xpath(whyShoppingOptions);
		
		 driver.findElement(selectShoppingOptions).click();
		
	}
	
	public void scroll(WebElement intoView) {
		jse.executeScript("arguments[0].scrollIntoView(true);", intoView);
	}
	
	public VehiclesPage clickSave() throws InterruptedException {
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@id,'SaveBtn')]")));
		Thread.sleep(2000);
		//scroll(driver.findElement(saveButton));
		driver.findElement(saveButton).click();
		

		VehiclesPage vehiclesPage = new VehiclesPage(driver, wait);
		return vehiclesPage;
		
	}
	
	public void enterAddress(String input) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("garagingAddressstart")));
		
		
		driver.findElement(parkingAddress).sendKeys(input);	
		
		Thread.sleep(2000);
		
		driver.findElement(selectAddressFromOptions).click();
		
	}
	
	public void enterYourDetails(String fName, String lName, String dob) {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverPIIstart")));
		
		//scroll(driver.findElement(firstName));
		
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		//scroll(driver.findElement(birthDate));
		driver.findElement(birthDate).sendKeys(dob);
		
	}

	
	public StartPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		
		jse = (JavascriptExecutor) driver; 
		
	}
	
}
