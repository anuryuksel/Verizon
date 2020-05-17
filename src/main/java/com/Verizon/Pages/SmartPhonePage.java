package com.Verizon.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Verizon.Base.BasePage;


import Verizon.Utilities.Constants;
import Verizon.Utilities.ElementUtil;


public class SmartPhonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	
	By phone = By.xpath("//a[@aria-label='Apple iPhone 11']");
	
	public SmartPhonePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.SMARTPHONES_PAGE_TITLE);
	}
	public PhoneFeatures selectPhone(){
		
		elementUtil.doClick(phone);
		return new PhoneFeatures(driver);
	}
	
}
