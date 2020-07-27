package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[contains(@class,'header-brand')]")
	private WebElement logoImage;
	
	@FindBy(className ="hero-headline")
	private WebElement headline;
	
	@FindBy(xpath ="//div[contains(@class,'radio-button')]/label[contains(@track-label,'Car insurance')]")
	private WebElement carInsurance;
	
	@FindBy(xpath ="//div[contains(@class,'radio-button')]/label[contains(@track-label,'Home insurance')]")
	private WebElement homeInsurance;
	
	@FindBy(xpath="//label[contains(@track-label,'Car')]")
	private WebElement carInsuranceSelect;
	
	@FindBy(xpath="//label[contains(@track-label,'Home')]")
	private WebElement homeInsuranceSelect;
	
	@FindBy(xpath ="//input[contains(@class,'zipcode-text-input')]")
	private WebElement zipcodeTextBox;
	
	@FindBy(xpath ="//button[contains(@type,'submit')]")
	private WebElement startButton;
	
	@FindBy(className ="header-nav")
	private WebElement navigationHeaders;
	
	@FindBy(xpath = "//div[contains(@class,'icon-grid')]/div[1]/h4")
	private WebElement shareSection;
	
	@FindBy(xpath = "//div[contains(@class,'icon-grid')]/div[2]/h4")
	private WebElement compareSection;
	
	@FindBy(xpath = "//div[contains(@class,'icon-grid')]/div[3]/h4")
	private WebElement saveSection;
	
	@FindBy(xpath = "//h2[contains(@class,'privacy-headline')]")
	private WebElement privacyPledge;
	
	@FindBy(xpath = "//p[contains(@class,'feature-body')]")
	private WebElement privacyParagraph;
	
	
	public void waitForPagetoLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'homepage')]/div/div/div")));
	}
	
	public boolean verifyPresenceofLogoImage() {	
		return logoImage.isDisplayed();
	}
	
	public boolean verifyHeaderText() {
		System.out.println("---"+headline.getText());
		return headline.getText().toString().contains("Insurance");
	}
	
	public boolean verifyCarInsuranceOption() {
		return carInsurance.isDisplayed();
	}
	
	public boolean verifyHomeInsuranceOption() {
		return homeInsurance.isDisplayed();
	}
	
	public boolean verifyZipCodeTextBox() {
		return zipcodeTextBox.isDisplayed();
	}
	
	public boolean verifyStartButton() {
		return startButton.isDisplayed();
	}
	
	public boolean verifyPrivacyText() {
		return privacyPledge.getText().toString().equals("Our Privacy Pledge");
	}
	
	public boolean verifyPrivacyWordings() {
		return privacyParagraph.getText().contains("Your privacy matters to us. So does your sanity. We pledge not to sell your information to spammers, and that means no annoying calls, texts or emails.");
	}
	
	public void selectCarInsurance() {
		carInsuranceSelect.click();
	}
	
	public void selectHomeInsurance() {
		homeInsuranceSelect.click();
	}
	
	public void enterZipCodeandStart(String input) {
		zipcodeTextBox.sendKeys(input);
		startButton.click();
		/*StartPage startPage = new StartPage(driver,wait);
		return startPage;*/
	}
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		
		PageFactory.initElements(driver, this);

	}
	
}
