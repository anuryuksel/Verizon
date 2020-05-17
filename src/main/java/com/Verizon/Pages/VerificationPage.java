package com.Verizon.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Verizon.Base.BasePage;

import Verizon.Utilities.Constants;
import Verizon.Utilities.ElementUtil;

public class VerificationPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	
	By phoneBrand = By.xpath("//div[@class='deviceInfoContainer']//h2//span//span[contains(text(),'iPhone 11')] ");
	
	public VerificationPage (WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String PageTitle(){
	return elementUtil.waitForGetPageTitle(Constants.VERIFICATION_PAGE);
	
	}
	
	public String getPhoneBrand(){
		return elementUtil.doGetText(phoneBrand);
	}
	
}
