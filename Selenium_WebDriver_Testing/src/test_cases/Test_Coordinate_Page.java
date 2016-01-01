package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Pilr_ParticipantPage;
import page_objects.Pilr_GroupPage;
import page_objects.Pilr_Create_Participant;

//this CLASS extends the AbstractTestCase which contains basic site
//navigation.  It will not run correctly if you attempt to run it directly 
//from Eclipse, as there are extra navigation steps in AbstractTestCase
//which will cause this test to be at the wrong page
//on the site when it starts.  Instead, this test case should be called from
//an xml file call Pilr_Verify_Coordinate_Page
//in there you will see a series of method calls that select only the 
//navigation methods necessary for this test case.
//methods are:
//<include name="SETUP" />
//<include name="TEST_LOGIN" />
//<include name="TEST_SELECT_PROJECT" /> CAPS INDICATES ABSTRACTTESTCASE METHOD
//<include name="test_Verify_NewParticipant_Page" />
//<include name="test_Verify_ViewGroups_Page" />
//<include name="test_View_Participant_Detail" />
//<include name="TEARDOWN" />
//Last update = 12/14/2015 by jjs


public class Test_Coordinate_Page extends AbstractTestCase {
    Pilr_Create_Participant objAddParticipant;
    Pilr_GroupPage objViewGroups;
    Pilr_ParticipantPage objParticipantPage;
   
    @Test (groups={"page_test"})
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
    
    @Test (groups={"page_test"})
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
    
    @Test (groups={"page_test"})
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
