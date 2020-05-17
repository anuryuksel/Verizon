package com.Verizon.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Verizon.Base.BasePage;

import Verizon.Utilities.ElementUtil;



public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By phonesList= By.xpath("//button[contains(text(),'Phones list')]");
	By smartphones = By.id("thirdLevel00");
	
	public HomePage(WebDriver driver){
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
		
	}
	public String getVerizonTitle(){
	return elementUtil.waitForGetPageTitle("Verizon Wireless, Smartphone Deals & Plans | First to 5G");

}
	
	public SmartPhonePage selectMenu(){
		elementUtil.mouseOver( driver, phonesList); // I used this in order to hover over the web element -- CSS:hover 
		elementUtil.doClick(smartphones);
		return new SmartPhonePage(driver);

		
	}
	
	}


