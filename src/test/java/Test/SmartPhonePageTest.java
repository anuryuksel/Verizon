package Test;

import java.util.Properties;
import java.util.concurrent.PriorityBlockingQueue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Verizon.Base.BasePage;
import com.Verizon.Pages.HomePage;
import com.Verizon.Pages.SmartPhonePage;

import Verizon.Utilities.Constants;

public class SmartPhonePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homepage;
	SmartPhonePage smartPhonePage;

@BeforeMethod
public void setUp(){
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	homepage = new HomePage(driver);
	smartPhonePage = homepage.selectMenu();
	
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		
//		e.printStackTrace();
//	}
}
@Test (priority=1, description= "SmartphonePage Title") 

public void getTitle(){
String title = smartPhonePage.getPageTitle();
Assert.assertEquals(title, Constants.SMARTPHONES_PAGE_TITLE);
}
@Test (priority=2, description="Phone")
public void selectPhone(){
	smartPhonePage.selectPhone();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}
}