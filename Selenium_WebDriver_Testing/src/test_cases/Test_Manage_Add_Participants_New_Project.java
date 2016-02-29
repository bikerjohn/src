package test_cases;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Bulk_Add_Participants_Page;
import page_objects.Bulk_Edit_Participants_Page;
import page_objects.Pilr_CoordinatePage;
import page_objects.Time_Wait;
import page_objects.Update_Group_Modal;
import page_objects.Update_Schedule_Modal;

public class Test_Manage_Add_Participants_New_Project extends AbstractTestCase {
	Pilr_CoordinatePage objCoordinatePage;
	Bulk_Add_Participants_Page objBulkAddParticipant;
	Bulk_Edit_Participants_Page objBulkEditParticipants;
	Update_Group_Modal objGroupModal;
	Update_Schedule_Modal objScheduleModal;
	TestVars objtestvars;
	Time_Wait objTimeWait;
	
	@Test
	//select the bulk add participants option in the Action group
	public void test_Bulk_Add_Participants(){
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		objBulkAddParticipant = new Bulk_Add_Participants_Page(driver);
		
		objCoordinatePage.select_Bulk_Add_Participants();
		Assert.assertTrue(objBulkAddParticipant.getbulkAddParticipantsWelcome().toLowerCase()
				.contains("bulk add participants"));		
	}
	
	@Test
	//in the Bulk Add Modal type the path of the import file and hit the import button
	public void test_Import_File_From_Directory(){
		objBulkAddParticipant = new Bulk_Add_Participants_Page(driver);
		objtestvars = new TestVars();
		
		objBulkAddParticipant.bulk_add_Participants(objtestvars.get_import_File_Name());
		objBulkAddParticipant.getImportFileMessage();
	}
	
	@Test
	//select the Bulk Edit Participants option in the Action group
	public void test_Bulk_Edit_New_Participants(){
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		objBulkEditParticipants = new Bulk_Edit_Participants_Page(driver);
		
		objCoordinatePage.select_Bulk_Edit_Participants();
		Assert.assertTrue(objBulkEditParticipants.get_bulk_Edit_Welcome().toLowerCase()
				.contains("bulk edit"));
	}
	
	@Test
	//complete the required fields necessary to launch the Update Groups Modal
	public void test_Prepare_to_Edit_Groups(){
		objBulkEditParticipants = new Bulk_Edit_Participants_Page(driver);
		objGroupModal = new Update_Group_Modal(driver);
		objTimeWait = new Time_Wait();
		
		objBulkEditParticipants.select_Edit_All_Checkbox();
		objBulkEditParticipants.select_Default_Assignment_Column(objtestvars.get_default_Assignments());
		objTimeWait.Duration(500);
		objBulkEditParticipants.select_Edit_Button();
		objBulkEditParticipants.select_Edit_Groups();
		objTimeWait.Duration(1000);
		Assert.assertTrue(objGroupModal.get_Group_Modal_Welcome().toLowerCase()
				.contains("bulk update groups"));
	}
	
	@Test
	//select the participant status in the Edit Groups modal
	public void test_Select_Group_Status(){
		objBulkEditParticipants = new Bulk_Edit_Participants_Page(driver);
		objGroupModal = new Update_Group_Modal(driver);
		objTimeWait = new Time_Wait();
		objTimeWait.Duration(2000);
		objGroupModal.select_Group_Status(objtestvars.get_participant_Status(),
				objtestvars.get_default_Assignments());
		
		//Assert.assertTrue(objGroupModal.Bulk_Update_Status().toLowerCase()
		//		.contains("bulk update success"));
		objGroupModal.close_Update_Group_Modal();
		objTimeWait.Duration(2000);
	}
	
	@Test
	//complete the required fields and launch the Update Schedule Modal
	public void test_Schedule_Active_Period(){
		objBulkEditParticipants = new Bulk_Edit_Participants_Page(driver);
		objScheduleModal = new Update_Schedule_Modal(driver);
		objTimeWait = new Time_Wait();
		
		objBulkEditParticipants.select_Edit_Button();
		objBulkEditParticipants.select_Edit_Schedule();
		objTimeWait.Duration(2000);
		Assert.assertTrue(objScheduleModal.getScheduleModalWelcome().toLowerCase()
				.contains("bulk update schedule"));
		objScheduleModal.Schedule_Active_Period();
	}
}
