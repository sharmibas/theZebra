package com.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.DriversPage;
import com.pages.HomePage;
import com.pages.Results;
import com.pages.StartPage;
import com.pages.VehiclesPage;

public class SmokeTest {
	
  WebDriver driver;
  WebDriverWait wait;
  
  HomePage homepage;
	
  @BeforeTest
  @Parameters({ "browserType" })
  public void initiateDriver(String browserType) {
	  
	  
	  String path = System.getProperty("user.dir");
	  
	  switch (browserType) {
	  
		case "Firefox":
			System.setProperty("webdriver.gecko.driver",path+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "IE":
			System.setProperty("webdriver.ie.driver",path+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
			System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
	  
	  driver.get("https://www.thezebra.com/");
	  
	  driver.manage().window().maximize();
	  
	  wait = new WebDriverWait(driver, 60);
	 
	  homepage = new HomePage(driver,wait);
	 
	  homepage.waitForPagetoLoad();
	  
  }
	
  @Test(enabled=false)
  public void verifyElementsOnHomePage() {
	  
	  homepage.waitForPagetoLoad();
	  
	  Assert.assertEquals(true, homepage.verifyPresenceofLogoImage());
	 
	  Assert.assertEquals(true, homepage.verifyCarInsuranceOption());
	  
	  Assert.assertEquals(true, homepage.verifyHomeInsuranceOption());
	  
	  Assert.assertEquals(true, homepage.verifyZipCodeTextBox());
	  
	  Assert.assertEquals(true, homepage.verifyStartButton());
	  
  }
  
  @Test(enabled=false)
  public void verifyTextOnHomePage() {
	  
	  homepage.waitForPagetoLoad();
	  
	  Assert.assertEquals(true, homepage.verifyHeaderText());
	  
	  Assert.assertEquals(true, homepage.verifyPrivacyText());
	  
	  Assert.assertEquals(true, homepage.verifyPrivacyWordings());
	  
  }
  
  @Test(enabled=true)
  public void getInsuranceQuote() throws InterruptedException {
	  
	  homepage.waitForPagetoLoad();
	  homepage.selectCarInsurance();
	  homepage.enterZipCodeandStart("08859");
	  
	  StartPage startPage = new StartPage(driver, wait);
	  
	  startPage.waitForPageToLoad();
	  startPage.selectInsuranceOption("No");
	  startPage.selectWhatyouOwn("IRent");
	  startPage.selectShopping("BuyingACarSoon");
	  startPage.clickSave();
	  startPage.waitForPageToLoad();
	  startPage.enterAddress("45 Kendall Drive");
	  startPage.enterYourDetails("Bob", "John", "07/30/1994");
	  
	  VehiclesPage vehiclePage = startPage.clickSave();
	  vehiclePage.addVehicleYear("2018");
	  vehiclePage.enterVehicleMake("Bmw");
	  vehiclePage.entervehicleModel("3Series");
	  vehiclePage.entervehicleName("Sedan");
	  vehiclePage.clickSave();
	  
	  vehiclePage.enterVehicleOwningInfo("Lease");
	  vehiclePage.enterVehicleUsageInfo("Pleasure");
	  vehiclePage.enterMileageDetails("100", "PerMonth");
	  
	  DriversPage driversPage = vehiclePage.clickSave();
	  
	  driversPage.selectGender("Male");
	  driversPage.selectMartialStatus("Single");
	  driversPage.selectMartialStatus("Good");
	  driversPage.selectMartialStatus("Master");
	  driversPage.violationsSelect("violations-0-No");
	  driversPage.enterEmailId("bob.alice@yahoo.com");
	  
	  ArrayList<String> discounts = new ArrayList<>();
	  discounts.add("currently_employed");
	  discounts.add("auto_pay");
	  discounts.add("paperless");
	  
	  driversPage.hearAbout("Facebook");
	  driversPage.addDriver("add_another-0-No");
	  
	  Results resultPage = driversPage.showQuotes();
	  Assert.assertEquals(true, resultPage.verifyResultsPage());
	  Assert.assertEquals(true, resultPage.verifyQuotesDisplayed());
  }
  
  
  
  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }
  
}
