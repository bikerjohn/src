package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Add_Instrument_Modal;
import page_objects.EMA_Config_Modal;
import page_objects.Pilr_Default_Template_Page;
import page_objects.Pilr_Project_Design;
import page_objects.Pilr_Project_Settings_Page;

import org.testng.annotations.AfterTest;

public class Test_Project_Design_Settings extends AbstractTestCase { 
	Pilr_Project_Settings_Page objProjectSettings;
	Pilr_Project_Design objProjectDesign;
	Add_Instrument_Modal objInstrumentModal;
	EMA_Config_Modal objEMAConfigModal;
	Pilr_Default_Template_Page objDefaultTemplate;
	
	@Test
	//Select the Default Template
	public void test_Select_Default_Template(){
		objProjectDesign = new Pilr_Project_Design(driver);
		objDefaultTemplate = new Pilr_Default_Template_Page(driver);
		
		objProjectDesign.Select_Default_Template();
		Assert.assertTrue(objDefaultTemplate.getDefTemplateWelcome().toLowerCase()
				.contains("view and edit the participant deployment template configuration"));
	}

}
