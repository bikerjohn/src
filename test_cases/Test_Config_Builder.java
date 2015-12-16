package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Pilr_Builder_Page;
import page_objects.Pilr_EMA_App_Home;
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
//Last update = 12/13/2015 by jjs

public class Test_Config_Builder extends AbstractTestCase {
	
    Pilr_Survey_ResponsePage objSurvResponsePage;
    Pilr_EMA_App_Home objEMAAppPage;
    
    
    public void test_Verify_EMA_App_Page(){
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	Assert.assertTrue(objEMAAppPage.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    }
    @Test
    public void test_Verify_Survey_Response_Page(){
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	//navigate to survey response page
    	objEMAAppPage.selectSurvResponse();
    	//verify that we landed on survey response page
    	Assert.assertTrue(objSurvResponsePage.getSurvey_ResponsePageWelcome().toLowerCase()
    			.contains("view participant survey responses"));
    }
}