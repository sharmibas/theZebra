package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse; 
	
	By saveButton = By.xpath("//button[contains(@id,'SaveBtn')]");
	
	By miles = By.xpath("//input[contains(@id,'miles-input')]");
	
	By milesDropdown = By.xpath("//div[contains(@class,'dropdown-select-wrap miles-item')]");
	
	By vehicleModules = By.id("vehicleInfo-0");
	
	public void addVehicleYear(String input) throws InterruptedException {
		
		Thread.sleep(2000);
		
		String vehicleYear = "//div[contains(@class,'vehicle-select')]/div[1]/div/div/div[contains(@id,'"+input+"')]";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(vehicleModules));
		
		scroll(driver.findElement(vehicleModules));
		
		WebElement vehicleYearEnter = driver.findElement(By.xpath(vehicleYear));
		
		vehicleYearEnter.click();
		
	}
	
	public void enterVehicleMake(String input) throws InterruptedException {
		
	Thread.sleep(1000);
		
	
	String vehicleType = "//div[contains(@class,'vehicle-select')]/div[2]/div/div/div[contains(@id,'"+input+"')]";
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vehicleType)));
	
	
	WebElement vehicleMake = driver.findElement(By.xpath(vehicleType));
	
	vehicleMake.click();
			
	}
	
	public void entervehicleModel(String input) throws InterruptedException {
		
		Thread.sleep(1000);
		
		String vehicleModel = "//div[contains(@class,'vehicle-select')]/div[3]/div/div/div[contains(@id,'"+input+"')]";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vehicleModel)));
		
		WebElement vehicleSeries = driver.findElement(By.xpath(vehicleModel));
		
		vehicleSeries.click();
				
		}
	
	public void entervehicleName(String input) throws InterruptedException {
		
		Thread.sleep(1000);

		String vehicleName = "//div[contains(@class,'vehicle-select')]/div[4]/div/div/div[contains(@id,'"+input+"')][1]";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'vehicle-select')]/div[4]")));
		
		WebElement vehicleFullName = driver.findElement(By.xpath(vehicleName));
		
		vehicleFullName.click();
				
		}
	
	public void enterVehicleOwningInfo(String input) throws InterruptedException {
		
		Thread.sleep(2000);
		
		String vechileOwn = "//label[contains(@data-cy,'"+input+"')]";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vechileOwn)));
		
		WebElement vechileOwnType = driver.findElement(By.xpath(vechileOwn));
		
		vechileOwnType.click();
				
		}
	
	public void enterVehicleUsageInfo(String input) throws InterruptedException {
		
		Thread.sleep(1000);
		
		String vechileUsage = "//label[contains(@data-cy,'"+input+"')]";
		
		WebElement vechileUsageinfo = driver.findElement(By.xpath(vechileUsage));
		
		vechileUsageinfo.click();
				
		}
	
	public void enterMileageDetails(String mileInput, String frequency) throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.findElement(miles).sendKeys(mileInput);
		
		String freq = "//div[contains(@class,'dropdown-select-wrap miles-item')]/div/div/div[contains(@id,'"+frequency+"')]";
		
		//scroll(driver.findElement(By.xpath(freq)));
		
		Thread.sleep(1000);
		
		driver.findElement(milesDropdown).click();
		
		WebElement freqElement = driver.findElement(By.xpath(freq));
		
		freqElement.click();
		
	}
	
	public void scroll(WebElement intoView) {
		jse.executeScript("arguments[0].scrollIntoView(true);", intoView);
	}
	
	public DriversPage clickSave() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@id,'SaveBtn')]")));
		Thread.sleep(2000);
		//scroll(driver.findElement(saveButton));
		driver.findElement(saveButton).click();
		
		DriversPage driversPage = new DriversPage(driver);
		return driversPage;
		
	}


	public VehiclesPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		
		jse = (JavascriptExecutor) driver; 
		
	}
	
}
