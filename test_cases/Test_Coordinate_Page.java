package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_ParticipantPage;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;
import page_objects.Pilr_GroupPage;
import page_objects.Pilr_Create_Participant;


public class Test_Coordinate_Page extends AbstractTestCase {
	PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_CoordinatePage objCoordinatePage;
    Pilr_EMA_App_Home objEmaApp;
    Pilr_Create_Participant objAddParticipant;
    Pilr_GroupPage objViewGroups;
    Pilr_ParticipantPage objParticipantPage;
    
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
    	try {
    		Thread.sleep(10000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	
     
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getProject());
     
        // verify that the correct project Coordinate Page is displayed
    	
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase().contains(
    			"coordinate participants and data"));
    	System.out.println("[Test Case]Coordinate Page Verified");
    	
    	//select the Instrument link 
    	objCoordinatePage.selectInstrument();
    	System.out.println("[Test Case]Select Instrument");
        // verify that the correct project Coordinate Page is displayed
    	
    	Assert.assertTrue(objEmaApp.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    	driver.navigate().back();
    	
    }
    
    @Test
    public void test_Verify_NewParticipant_Page() {
    	
    	//select the Add Participant option
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage.Create_Participant();
    	System.out.println("[Test Case]Add Participant");
    	try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	
    	Assert.assertTrue(objAddParticipant.getnewparticipantPageWelcome()
    			.toLowerCase().contains("new participant"));
    	System.out.println("[Test Case]New Participant Page Verified");
    	driver.navigate().back();
    }
    
    @Test
    public void test_Verify_ViewGroups_Page() {
    	
    	//select the Add Participant option
    	objViewGroups = new Pilr_GroupPage(driver);
    	objCoordinatePage.selectViewGroups();
    	try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	
    	Assert.assertTrue(objViewGroups.getGroupPageWelcome()
    			.toLowerCase().contains("participant category memberships"));
    	System.out.println("[Test Case]View Groups Page Verified");
    	driver.navigate().back();
    }
    
    @Test
    public void test_View_Participant_Detail() {
    	
    	//select the Participant link
    	//need to change this to right code
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objCoordinatePage.selectParticipant(objtestvars.getPartCode());
    	try {
    		Thread.sleep(5000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    	
    	Assert.assertTrue(objParticipantPage.getparticipantPageWelcome()
    			.toLowerCase().contains("participant "+objtestvars.getPartCode()));
    	System.out.println("[Test Case]Participant Page Verified");
    }
}
