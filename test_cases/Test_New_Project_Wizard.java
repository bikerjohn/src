package test_cases;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Pilr_Project_Wizard;
import page_objects.Project_Wizard_Config_Options;
import page_objects.Project_Wizard_Duration;


public class Test_New_Project_Wizard extends AbstractTestCase {
	Pilr_Project_Wizard objProjectWizard;
	Project_Wizard_Config_Options objProjectConfig;
	Project_Wizard_Duration objProjectDuration;
	String new_project_name;
	
	//Create the name for the new project (text + date time for uniqueness)
		public String createProjName(){
			String new_project_name;
			new_project_name = "test"+LocalDateTime.now();
			return new_project_name;
		}

	@Test
    public void test_Name_New_Project(){
    	objProjectWizard = new Pilr_Project_Wizard(driver);
    	
    	//verify that we landed on survey response page
    	Assert.assertTrue(objProjectWizard.getProjWizardPageWelcome().toLowerCase()
    			.contains("new project wizard"));
    	//start the project creation process by naming it
    	this.new_project_name = createProjName();
    	objProjectWizard.createProject(new_project_name);
    }
	@Test
	public void test_Select_New_Project_Config_From_Scratch(){
		objProjectConfig = new Project_Wizard_Config_Options(driver);
		Assert.assertTrue(objProjectConfig.getConfigOptionsWelcome().toLowerCase()
    			.contains("setup the project design"));
		//select the Build from Scratch option
		objProjectConfig.selectBuildFromScratch();
		objProjectConfig.selectNext();
	}
	@Test
	public void test_Set_New_Project_Duration(){
		objProjectDuration = new Project_Wizard_Duration(driver);
		Assert.assertTrue(objProjectDuration.getDurationWelcome().toLowerCase()
    			.contains("a little more help to get started quicker"));
		//select the Finish button to finish creating a project
		objProjectDuration.selectFinish();
	}
}
 