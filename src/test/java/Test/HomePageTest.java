package Test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Verizon.Base.BasePage;
import com.Verizon.Pages.HomePage;

import Verizon.Utilities.Constants;



public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homepage;
	
	@BeforeMethod 
	public void setUp(){
	 basePage = new BasePage();
	 prop = basePage.initialize_properties();
	 driver = basePage.initialize_driver(prop);
	 homepage = new HomePage(driver);
	
	}
	@Test (priority=1, description="Home Page title ")
	public void getTitle(){
		String title = homepage.getVerizonTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals(title, Constants.VERIZON_TITLE );
	}
	
	
	@Test (priority=2, description="smartphones")
	public void clickSmartPhones(){
		homepage.selectMenu();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}


}
	