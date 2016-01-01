package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;


public class TestPilrSelectProject extends AbstractTestCase {
	 
    PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_CoordinatePage objCoordinatePage;
    Pilr_EMA_App_Home objEmaApp;
    
 
    @Test(priority=0)
     
    public void test_Home_Page_Appears_Correctly(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    
    	//Verify login page title
    	String loginPageTitle = objLogin.getPageSource();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("sign in"));

 
    	//login to application
    	objLogin.loginToPilr(objtestvars.getUserName(), 
    			objtestvars.getPassWrd());
 
    	// go the next page
    	objHomePage = new PilrHomePage(driver);
 
    	//Verify home page
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase().contains(
    			"welcome back, bikerjohn!"));
    	System.out.println("[Test Case]Home Page Verified");
    	
    
    }
    @Test
    public void test_Select_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objEmaApp = new Pilr_EMA_App_Home(driver);
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
     
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getProject());
     
        // verify that the correct project Coordinate Page is displayed
    	
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase().contains(
    			"coordinate participants and data"));
    	System.out.println("[Test Case]Coordinate Page Verified");
    	//select the Instrument link 
    	objCoordinatePage.selectInstrument();
     
        // verify that the correct project Coordinate Page is displayed
    	
    	Assert.assertTrue(objEmaApp.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    }
 

}
