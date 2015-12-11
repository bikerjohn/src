package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_RegisterPage;
import page_objects.Pilr_ForgotPwd;

public class TestNewUserRegistration extends AbstractTestCase {
	 
    PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_RegisterPage objRegPage;
    Pilr_ForgotPwd pwdResetPage;

 
    @Test(priority=0)
     
    public void test_New_User_Registration(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    	
    
    	//Verify login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));
    	System.out.println("[Test Case]Login Page Verified");
 
    	// select Register option
    	objLogin.registerAsNewUser();
    	
    	// go the Registration page and verify that it is open
    	objRegPage = new Pilr_RegisterPage(driver);
    	Assert.assertTrue(objRegPage.getRegisterPageWelcome().toLowerCase().contains("new "
    			+ "user registration"));
    	System.out.println("[Test Case]Registration Page Verified");
    	
    	//complete registration form
    	objRegPage.registerNewuser("eaglemanjjs@hotmail.com", "bikerjjs1", "John", 
    			"Shade", "MEI Ltd", "$Testtest1", "$Testtest1");
    	
    	//Assert.assertTrue(objRegPage.getRegisterSubmit().toLowerCase().contains(
    	//		"you are registered! go ahead and login"));
    
    }
   
}
