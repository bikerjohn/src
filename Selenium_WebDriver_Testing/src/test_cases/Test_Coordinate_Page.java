package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Pilr_ParticipantPage;
import page_objects.Schedule_Participant_Modal;
import page_objects.Time_Wait;
import page_objects.Pilr_GroupPage;
import page_objects.Add_Device_Modal;
import page_objects.Pilr_CoordinatePage;
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
    Schedule_Participant_Modal objScheduleParticipantModal;
    Add_Device_Modal objAddParticipantDevice;
    Time_Wait objTimeWait;
   
    @Test (groups={"page_test"})
    public void test_Verify_NewParticipant_Page() {
    	
    	//select the Add Participant option
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage.Create_Participant();
    	objTimeWait = new Time_Wait();
    	
    	System.out.println("[Test Case]Add Participant");
    	objTimeWait.Duration(3000);   	
    	Assert.assertTrue(objAddParticipant.getnewparticipantPageWelcome()
    			.toLowerCase().contains("new participant"));
    	System.out.println("[Test Case]New Participant Page Verified");
    	driver.navigate().back();
    }
    @Test
    //select the add participant option in the Action group
    public void test_Add_Participant_Action(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objCoordinatePage.Create_Participant();
    	objTimeWait.Duration(1000);
    	Assert.assertTrue(objAddParticipant.getnewparticipantPageWelcome().toLowerCase()
    			.contains("new participant"));
    }
    @Test
    //complete the fields in the add participant modal and hit save
    public void test_Create_New_Participant(){
    	objAddParticipant = new Pilr_Create_Participant(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objTimeWait = new Time_Wait();
    	
    	objAddParticipant.completeCreateParticipantForm(objtestvars.getPartCode(), objtestvars.getPartDesc());
    }
    @Test
    //Schedule the new participants active period
    public void test_Schedule_Participant_Active_Period(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objScheduleParticipantModal = new Schedule_Participant_Modal(driver);
    	objTimeWait = new Time_Wait();
    	
    	objParticipantPage.select_Participant_Schedule();
    	objTimeWait.Duration(2000);
    	objScheduleParticipantModal.get_Schedule_Participant_Welcome();
    	objScheduleParticipantModal.set_Participant_Start_Date();
    	objTimeWait.Duration(2000);
    }
    @Test
    //Add a device to the new participants setup
    public void test_Add_Participant_Device(){
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objParticipantPage = new Pilr_ParticipantPage(driver);
    	objAddParticipantDevice = new Add_Device_Modal(driver);
    	objTimeWait=new Time_Wait();
    	
    	objParticipantPage.Add_Participant_Device();
    	objTimeWait.Duration(1000);
    	Assert.assertTrue(objAddParticipantDevice.Get_addDevice_Welcome().toLowerCase()
    			.contains("setup device activation information"));
    	objAddParticipantDevice.createLoginID(objtestvars.getUserName());
    	
    }
    
    @Test (groups={"page_test"})
    public void test_Verify_ViewGroups_Page() {
    	
    	//select the Add Participant option
    	objViewGroups = new Pilr_GroupPage(driver);
    	objCoordinatePage.selectViewGroups();
    	objTimeWait = new Time_Wait();
    	
    	objTimeWait.Duration(3000); 
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
    	objTimeWait = new Time_Wait();
    	
    	objTimeWait.Duration(5000); 
    	Assert.assertTrue(objParticipantPage.getparticipantPageWelcome()
    			.toLowerCase().contains("participant "+objtestvars.getPartCode()));
    	System.out.println("[Test Case]Participant Page Verified");
    }
}
