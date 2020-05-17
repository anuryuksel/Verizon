package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Verizon.Base.BasePage;
import com.Verizon.Pages.HomePage;
import com.Verizon.Pages.PhoneFeatures;
import com.Verizon.Pages.SmartPhonePage;

import Verizon.Utilities.Constants;

public class PhoneFeaturesTest {

WebDriver driver;
Properties prop;
BasePage basePage;
SmartPhonePage smartPhonePage;
HomePage homePage;
PhoneFeatures phoneFeatures;

@BeforeMethod
public void setUp(){
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	homePage = new HomePage(driver); 
	smartPhonePage = homePage.selectMenu();
	phoneFeatures = smartPhonePage.selectPhone();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}

}

@Test (priority=1 , description= "Page title")
public void getTitle() throws InterruptedException{
	String title = phoneFeatures.getTitle();
	System.out.println("Phone title is: " + title);
	Assert.assertEquals(title, Constants.SELECTED_PHONE_TITLE);
}

@Test(priority=2 , description= "Phone Brand")
public void PhoneBrand(){
	String brand = phoneFeatures.getPhoneBrand();
	System.out.println("Selected Phone Brand is: " + brand);
	Assert.assertEquals(brand, Constants.PHONE_BRAND);
}

@Test(priority=3 , description= "Features")
public void selectPhoneFeatures(){
	phoneFeatures.SelectFeatures();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}



}
