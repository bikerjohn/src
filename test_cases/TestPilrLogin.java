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

public class TestPilrLogin {
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
     
    public void test_Home_Page_Appears_Correctly(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    
    	//Verify login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
 
    	//login to application
    	objLogin.loginToPilr("bikerjohn", "$Rtchierans9x1");
 
    	// go the next page
    	objHomePage = new PilrHomePage(driver);
 
    	//Verify home page
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase().contains("welcome back, bikerjohn!"));
    	navbar = new Pilr_Navbar(driver);
    	navbar.clickLogout();
    
    }
    @Test
    public void test_Failed_Login(){
    	objLogin = new PilrLogin(driver);
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
     
        //login to application
    	objLogin.FailedloginToPilr("bikerjohn", "badpassword");
     
        // verify that the correct failure text is displayed
    	
    	Assert.assertTrue(objLogin.getErrorMessage().toLowerCase().contains("sorry, we were not able to find a user with that username and password."));
    }
    
    @Test
    public void test_Register_Select(){
    	objLogin = new PilrLogin(driver);
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
    	
    	// select Register option
    	objLogin.registerAsNewUser();
    	
    	// go the next page
    	objRegPage = new Pilr_RegisterPage(driver);
    	Assert.assertTrue(objRegPage.getRegisterPageWelcome().toLowerCase().contains("new user registration"));
    	objRegPage.clickLoginReturn();
    }
 
    @Test
    public void test_ResetPwd_Select(){
    	objLogin = new PilrLogin(driver);
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
    	
    	// select password reset option
    	objLogin.pwdReset();
    	
    	// go the next page
    	pwdResetPage = new Pilr_ForgotPwd(driver);
    	Assert.assertTrue(pwdResetPage.getRegisterPageWelcome().toLowerCase().contains("retrieve password"));
    }
    @AfterTest

    public void tearDown() throws Exception {
    	driver.quit();
      
      
    }
}
