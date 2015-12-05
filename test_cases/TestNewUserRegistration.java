package test_cases;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_RegisterPage;
import page_objects.Pilr_ForgotPwd;

public class TestNewUserRegistration {
	
	WebDriver driver;
	 
    PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_RegisterPage objRegPage;
    Pilr_ForgotPwd pwdResetPage;

	@BeforeTest
	 
    public void setup(){
 
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://qa.pilrhealth.com/");
 
    }
 
    @Test(priority=0)
     
    public void test_New_User_Registration(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    	
    
    	//Verify login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
 
    	// select Register option
    	objLogin.registerAsNewUser();
    	
    	// go the Registration page and verify that it is open
    	objRegPage = new Pilr_RegisterPage(driver);
    	Assert.assertTrue(objRegPage.getRegisterPageWelcome().toLowerCase().contains("new "
    			+ "user registration"));
    	
    	//complete registration form
    	objRegPage.registerNewuser("eaglemanjjs@hotmail.com", "bikerjjs1", "John", 
    			"Shade", "MEI Ltd", "$Testtest1", "$Testtest1");
    	
    	//Assert.assertTrue(objRegPage.getRegisterSubmit().toLowerCase().contains(
    	//		"you are registered! go ahead and login"));
    
    }
   
    @AfterTest

    public void tearDown() throws Exception {
    	driver.quit();
      
      
    }
}
