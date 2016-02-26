package test_cases;
import java.lang.management.ManagementFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Add_Instrument_Modal;
import page_objects.EMA_Config_Modal;
import page_objects.PilrHomePage;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_Default_Template_Page;
import page_objects.Pilr_Project_Design;
import page_objects.Pilr_Project_Settings_Page;
import page_objects.Time_Wait;

import org.testng.annotations.AfterTest;

public class Test_Project_Design_Settings extends AbstractTestCase { 
	Pilr_Project_Settings_Page objProjectSettings;
	Pilr_Project_Design objProjectDesign;
	Add_Instrument_Modal objInstrumentModal;
	EMA_Config_Modal objEMAConfigModal;
	Pilr_Default_Template_Page objDefaultTemplate;
	Time_Wait objTimeWait;
	String new_project_name = "test"+ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	
	@Test
	public void test_Select_New_Project_Name(){
		//Select the new project created in the Create Project From Scratch Test Case
		objHomePage = new PilrHomePage(driver);
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		
		objHomePage.selectProject(new_project_name);
		Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
				.contains("coordinate participants and data"));
	}
	
	@Test
	//Select the Default Template
	public void test_Select_Default_Template(){
		objProjectDesign = new Pilr_Project_Design(driver);
		objDefaultTemplate = new Pilr_Default_Template_Page(driver);
		
		objProjectDesign.Select_Default_Template();
		Assert.assertTrue(objDefaultTemplate.getDefTemplateWelcome().toLowerCase()
				.contains("view and edit the participant deployment template configuration"));
	}
	
	@Test
	//Select the Add Instrument method
	public void test_Add_Instrument_to_Template(){
		objDefaultTemplate = new Pilr_Default_Template_Page(driver);
		objInstrumentModal = new Add_Instrument_Modal(driver);
		objTimeWait = new Time_Wait();
		
		objDefaultTemplate.actionsAddInstrument();
		objTimeWait.Duration(1000);
		Assert.assertTrue(objInstrumentModal.getAddInstrumentWelcome().toLowerCase()
				.contains("add instrument"));
		
	}
	
	@Test
	//Save the Instrument Selection
	public void test_Save_Instrument_Selection(){
		objDefaultTemplate = new Pilr_Default_Template_Page(driver);
		objInstrumentModal = new Add_Instrument_Modal(driver);
		objTimeWait = new Time_Wait();
		
		objInstrumentModal.addInstrument();
	
	}
	
	@Test
	//Select the ema config for the instrument settings
	public void test_Set_EMA_Config(){
		objDefaultTemplate = new Pilr_Default_Template_Page(driver);
		objEMAConfigModal = new EMA_Config_Modal(driver);
		objTimeWait = new Time_Wait();
		
		//select the ema config in the instrument settings panel
		objDefaultTemplate.selectInstrument();
		objTimeWait.Duration(1000);
		//Assert.assertTrue(objEMAConfigModal.getModalWelcome().toLowerCase()
		//		.contains("create ema_ots:ema_config for epoch 1 "));
		objEMAConfigModal.clickRadioButton();
		objEMAConfigModal.clickSave();
		
	}

}
