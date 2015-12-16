package test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Builder_Page;
import page_objects.Pilr_Config_Builder;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_ParticipantPage;
import page_objects.Pilr_Survey_ResponsePage;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;
import page_objects.Pilr_GroupPage;
import org.apache.log4j.Logger;


public class AbstractTestCase {

	protected WebDriver driver;
	PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_CoordinatePage objCoordinatePage;
    Pilr_EMA_App_Home objEMAAppPage;
	TestVars objtestvars;
	Pilr_Builder_Page objEMABuilderPage;
	Pilr_Config_Builder objConfigBuilder;
	Pilr_Survey_ResponsePage objSurvResponsePage;

	public AbstractTestCase() {
		super();
	}

	@BeforeTest
	public void setup() {
	
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://qa.pilrhealth.com/");
	    objtestvars = new TestVars();
	    final Logger log = Logger.getLogger(AbstractTestCase.class);
	
	}
    @Test(priority=0)
    
    public void test_Login(){
    	
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
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
    	
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getProject());
    	try {
    		Thread.sleep(10000); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    }
    	
    @Test 
    public void test_Select_Instrument() {
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase().contains(
    			"coordinate participants and data"));
    	System.out.println("[Test Case]Coordinate Page Verified");
    	  	
    	//select the Instrument link 
    	objCoordinatePage.selectInstrument();
    	System.out.println("[Test Case]Select Instrument");
        // verify that the correct project Coordinate Page is displayed
    	
    	Assert.assertTrue(objEMAAppPage.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    	
    }
    @Test
    public void test_Verify_EMA_App_Page(){
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	Assert.assertTrue(objEMAAppPage.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    }
    @Test
    public void test_Verify_EMA_Builder_Page(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	//navigate to survey response page
    	objEMAAppPage.selectEMABuilder();
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objEMABuilderPage.getBuilderPageWelcome().toLowerCase()
    			.contains("ema configurations"));
    }
    @Test
    public void test_Verify_Config_Builder_Page(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	//navigate to survey response page
    	objEMABuilderPage.selectEMAConfig(objtestvars.getEmaConfig());
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objConfigBuilder.getconfigbuilderPageWelcome().toLowerCase()
    			.contains("ema configuration builder"));
    }
	@AfterTest

    public void tearDown() throws Exception {
    	driver.quit();
      
      
    }

}