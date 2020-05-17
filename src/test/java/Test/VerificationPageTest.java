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
import com.Verizon.Pages.VerificationPage;

import Verizon.Utilities.Constants;

public class VerificationPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	PhoneFeatures phoneFeatures;
	SmartPhonePage smartPhonePage;
	HomePage homePage;
	VerificationPage verificationPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartPhonePage = homePage.selectMenu();
		phoneFeatures  = smartPhonePage.selectPhone();
		verificationPage = phoneFeatures.SelectFeatures();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
		
		@Test (priority = 1, description="Verification Page Title")
		public void getText(){
		String text =verificationPage.PageTitle();
		System.out.println(text);
		Assert.assertEquals(text, Constants.VERIFICATION_PAGE);
		}
	
		@Test (priority =2 , description="Verified Phone Brand")
	
		public void verifyPhoneBrand(){
		String brand = verificationPage.getPhoneBrand();
		System.out.println(brand);
		Assert.assertEquals(brand, Constants.PHONE_BRAND);
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
	}
	
	
	

	

