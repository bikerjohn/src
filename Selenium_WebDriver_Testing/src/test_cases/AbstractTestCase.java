package test_cases;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Delete_Project_Modal;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Builder_Page;
import page_objects.Pilr_Config_Builder;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_Org_Page;
import page_objects.Pilr_ParticipantPage;
import page_objects.Pilr_Project_Design;
import page_objects.Pilr_Project_Settings_Page;
import page_objects.Pilr_Project_Wizard;
import page_objects.Pilr_Survey_ResponsePage;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;
import page_objects.Pilr_GroupPage;
//import org.apache.log4j.Logger;


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
	Pilr_Org_Page objOrgPage;
	Pilr_Project_Wizard objProjWizard;
	Pilr_Project_Settings_Page objProjectSettings;
	Pilr_Project_Design objProjectDesign;
	Delete_Project_Modal objDeleteProjectModal;
	String new_project_name = "test"+ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	String pilr_org;

	public AbstractTestCase() {
		super();
	}
	
	
	@BeforeTest
	public void setup() {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		String matt = "/Users/matt/git/src/Selenium_WebDriver_Testing";
		String john = "C:/serv/mei/MEI_UA_Testing/";
		
		//Check if it's Matt's system via string comparison
		if((System.getProperty("user.dir")).equals(matt)){
			
			//Matt
			System.setProperty("webdriver.chrome.driver", "/Users/matt/Desktop/MEI/chromedriver");
			
			//Set path related variables
			objtestvars = new TestVars();
			//objtestvars.set_import_File_Name("/Users/matt/Desktop/MEI/bulk_participants.csv");
			objtestvars.set_EMA_Config_Defs("/Users/matt/Desktop/MEI/ema-configs-standard-surveys-wtriggers.json");
			
			//System.out.println(objtestvars.get_import_File_Name());
			System.out.println(objtestvars.get_EMA_Config_Defs());
			System.out.println("Matt's System");
			
		}
		else if((System.getProperty("user.dir")).equals(john)){
			
			//John
			System.out.println(System.setProperty("webdriver.chrome.driver", "C:/Users/eagle/Program Files/chromedriver_win32/chromedriver.exe"));
			
			//Set path related variables
			objtestvars = new TestVars();
			//objtestvars.set_import_File_Name("C:\\srv\\mei\\bulk_participants.csv");
			objtestvars.set_EMA_Config_Defs("C:\\srv\\mei\\emacontent\\ema-configs-standard-surveys-wtriggers.json");
			System.out.println("John's System");
			
		}
		driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    //driver.get("https://staging.pilrhealth.com/");
	    driver.get("https://qa.pilrhealth.com/");
	    //objtestvars = new TestVars();
	    //final Logger log = Logger.getLogger(AbstractTestCase.class);
	
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
	public void test_Select_New_Project_Name(){
		//Select the new project created in the Create Project From Scratch Test Case
		objHomePage = new PilrHomePage(driver);
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		
		objHomePage.selectProject(new_project_name);
		Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
				.contains("coordinate participants and data"));
	}
    @Test 
    public void test_Select_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
    	
    	//expand the org group for this project
    	objHomePage.expandOrg(objtestvars.getExistingOrg());
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
    public void test_Select_New_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	Assert.assertTrue(objHomePage.getHomePageWelcome().toLowerCase()
    			.contains("welcome back, bikerjohn!"));
    	
        //select the Project link based on the testvars project value
    	objHomePage.selectProject(objtestvars.getNewProject());
    }
    	
    @Test 
    public void test_Select_Instrument() {
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
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
    public void test_Select_EMA_App_Page(){
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	Assert.assertTrue(objEMAAppPage.getEMAAppPageWelcome()
    			.toLowerCase().contains(
    			"overview of participants"));
    }
    @Test
    public void test_Select_Survey_Response_Page(){
    	objSurvResponsePage = new Pilr_Survey_ResponsePage(driver);
    	objEMAAppPage = new Pilr_EMA_App_Home(driver);
    	//navigate to survey response page
    	objEMAAppPage.selectSurvResponse();
    	//verify that we landed on survey response page
    	Assert.assertTrue(objSurvResponsePage.getSurvey_ResponsePageWelcome().toLowerCase()
    			.contains(" view participant survey responses"));
    	objCoordinatePage.browseData();	
    }
    @Test
    public void test_Select_EMA_Builder_Page(){
    	objEMABuilderPage = new Pilr_Builder_Page(driver);
    	//navigate to survey response page
    	objEMAAppPage.selectEMABuilder();
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objEMABuilderPage.getBuilderPageWelcome().toLowerCase()
    			.contains("ema configurations"));
    }
    @Test
    public void test_Select_Config_Builder_Page(){
    	objConfigBuilder = new Pilr_Config_Builder(driver);
    	//navigate to survey response page
    	objEMABuilderPage.selectEMAConfig(objtestvars.getEmaConfig());
    	//verify that we landed on the EMA Builder page
    	Assert.assertTrue(objConfigBuilder.getconfigbuilderPageWelcome().toLowerCase()
    			.contains("ema configuration builder"));
    }
    @Test
    public void test_Select_Organization_Page(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	//navigate to organization page
    	objHomePage.selectOrganization(objtestvars.getOrg());
    	//verify that we landed on the Organization page
    	Assert.assertTrue((objOrgPage.getOrgPageWelcome().toLowerCase()
    			.contains("organization settings")));
    }
    @Test
    public void test_Create_Project(){
    	objProjWizard = new Pilr_Project_Wizard(driver);
    	//navigate to organization page
    	objOrgPage.createProject();
    	//verify that we landed on the Project Wizard Page
    	Assert.assertTrue((objProjWizard.getProjWizardPageWelcome().toLowerCase()
    			.contains("new project wizard")));
    }
    @Test
    //navigate to the Project Design Page
    public void test_Nav_Project_Design(){
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	objProjectDesign = new Pilr_Project_Design(driver);
    	//nav to project Design
    	objProjectSettings.nav_Project_Design();
    	//verify we landed on the Project Settings Page
    	Assert.assertTrue(objProjectDesign.getProjectDesignWelcome().toLowerCase()
    			.contains("setup and edit the design of the project (e.i. who uses what, when?)"));
    }
    @Test
    //navigate to the Project Settings Page
    public void test_Nav_Project_Settings(){
    	navbar = new Pilr_Navbar(driver);
    	objProjectSettings = new Pilr_Project_Settings_Page(driver);
    	//click the gear icons to go to the Project Settings Page
    	navbar.click_Project_Settings_Icon();
    	//verify we landed on the Project Settings Page
    	Assert.assertTrue(objProjectSettings.getprojectSettingsWelcome().toLowerCase()
    			.contains("add, edit, or remove the components used on this project."));   	
    }
    @Test
    //navigate to the Coordinate Projects Page
    public void test_Nav_Coordinate_Page(){
    	navbar = new Pilr_Navbar(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	//click the dashboard icon to go the Coordinate Project page
    	navbar.click_Project_Coordinate_Icon();
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
    			.contains("coordinate participants and data"));
    	
    }
    @Test
    //delete new project
    public void test_Delete_Newly_Added_Project(){
    	objOrgPage = new Pilr_Org_Page(driver);
    	navbar = new Pilr_Navbar(driver);
    	objDeleteProjectModal = new Delete_Project_Modal(driver);
 
    	pilr_org = (objtestvars.getOrg());
    	navbar.Nav_to_Org_Page(pilr_org);
    	Assert.assertTrue(objOrgPage.getOrgPageWelcome()
    			.contains(objtestvars.getOrg()));
    	objOrgPage.delete_Project(new_project_name);
    	Assert.assertTrue(objDeleteProjectModal.get_Delete_Project_Welcome().toLowerCase()
    			.contains("are you sure you want to delete this project?"));
    	objDeleteProjectModal.click_Confirm_Delete();
    }
    @Test
    public void test_Logout(){
    	navbar = new Pilr_Navbar(driver);
    	navbar.clickLogout();
    }
	@AfterTest

    public void tearDown() throws Exception {
    	driver.quit();
      
      
    }

}