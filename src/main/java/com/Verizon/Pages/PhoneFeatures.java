package com.Verizon.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Verizon.Utilities.Constants;
import Verizon.Utilities.ElementUtil;

import com.Verizon.Base.BasePage;



public class PhoneFeatures extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	By phoneBrand = By.xpath("//h1[contains(text(),'Apple iPhone 11')]");
	By color= By.xpath("//div[@style='background-color: rgb(204, 197, 215);']");
	By size = By.xpath("//p[text()='128GB']");
	By payment = By.xpath("//span[text()='$749.99']"); // - yeni xpath deneyelim
	By contBtn= By.id("ATC-Btn");	
	By zip = By.id("zipcode");
	By confirmBtn1 = By.xpath("//button[@type='submit']");
	By newuser = By.xpath("//button[@aria-label='New Customer']");
	
	
	
	
	
	public PhoneFeatures(WebDriver driver){
		this.driver = driver;
		elementUtil= new ElementUtil(driver);
	}
	
	
	
	public String getTitle() throws InterruptedException{
		Thread.sleep(4000);
		return elementUtil.waitForGetPageTitle(Constants.SELECTED_PHONE_TITLE);
		
	}
	public String getPhoneBrand(){
		return elementUtil.doGetText(phoneBrand);
	}
	public VerificationPage SelectFeatures(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		elementUtil.doClick(color);
		elementUtil.doClick(size);
		elementUtil.doClick(payment);
		elementUtil.doClick(contBtn);
		
	
		elementUtil.waitForElementPresentBy(zip);
		elementUtil.doSendKeys(zip,  "07407");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		driver.findElement(zip).sendKeys(prop.getProperty("zipCode"),Keys.TAB,Keys.ENTER );
		elementUtil.doClick(confirmBtn1);
		elementUtil.doClick(newuser);
		return new VerificationPage(driver);
	}
	
}
