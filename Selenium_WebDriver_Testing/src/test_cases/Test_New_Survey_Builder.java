package test_cases;

import java.lang.management.ManagementFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Builder_EMAConfig_Page;
import page_objects.PilrHomePage;
import page_objects.Pilr_Builder_Page;
import page_objects.Pilr_Config_Builder;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;
import page_objects.Pilr_Survey_Builder;
import page_objects.Pilr_Survey_ResponsePage;

//this test case extends the AbstractTestCase which contains basic site
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
//<include name="TEST_SELECT_PROJECT" />
//<include name="TEST_SELECT_INSTRUMENT" />  CAPS INDICATES ABSTRACTTESTCASE METHOD
//<include name="test_Verify_EMA_App_Page" />
//<include name="test_Verify_Survey_Response_Page" />
//<include name="test_Verify_EMA_Builder_Page" />
//<include name="TEARDOWN" />
//Last update = 12/15/2015 by jjs


public class Test_New_Survey_Builder extends AbstractTestCase {
		Pilr_Survey_Builder objSurveyBuilder;
		Pilr_Config_Builder objConfigBuilder;
		PilrHomePage objHomePage;
		Pilr_CoordinatePage objCoordinatePage;
		Builder_EMAConfig_Page objEMAConfigBuilder;
		Pilr_Builder_Page objPilrBuilderPage;
		String new_project_name = "test"+ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
//need to add the config builder and survey builder objects

	@Test
		//Need to add methods for creating a new survey
		//Create a new Survey
		//Create a new Section
		//Add a card to a Section
	public void test_Survey_Editor_Page(){
	objSurveyBuilder = new Pilr_Survey_Builder(driver);
	objConfigBuilder = new Pilr_Config_Builder(driver);
	//navigate to survey response page
	objConfigBuilder.selectSurvey(objtestvars.getSurveyName());
	//verify that we landed on survey builder page
	Assert.assertTrue(objSurveyBuilder.getsurveyBuilderWelcome().toLowerCase()
			.contains("delete config test1"));
	}

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
	public void test_Select_New_EMA_Config(){
		//Add a new EMA config for this project
		objEMAConfigBuilder = new Builder_EMAConfig_Page(driver);
		objPilrBuilderPage = new Pilr_Builder_Page(driver);
		
		//call the create ema configuration method
		objPilrBuilderPage.addEMAConfig(new_project_name);
		Assert.assertTrue(objEMAConfigBuilder.getEmaConfigBuilderWelcome().toLowerCase()
				.contains("create an ema configuration"));
		
	}
	@Test
	public void test_Create_New_EMA_Config(){
		objEMAConfigBuilder = new Builder_EMAConfig_Page(driver);
		objPilrBuilderPage = new Pilr_Builder_Page(driver);
		
		objEMAConfigBuilder.createEMAConfig(objtestvars.getNewEMAConfig());
		Assert.assertTrue(objPilrBuilderPage.getBuilderPageWelcome().toLowerCase()
				.contains("ema configurations"));
	}
	
}