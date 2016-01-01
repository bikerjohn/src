package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_EMA_App_Home;

public class Test_Select_Project extends AbstractTestCase{
	PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_CoordinatePage objCoordinatePage;
    Pilr_EMA_App_Home objEmaApp;
    
    @Test
    public void test_Select_Project() {
    	objHomePage = new PilrHomePage(driver);
    	objCoordinatePage = new Pilr_CoordinatePage(driver);
    	objEmaApp = new Pilr_EMA_App_Home(driver);
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
     
    	Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome()
    			.toLowerCase().contains(
    			"coordinate participants and data"));
    	System.out.println("[Test Case]Coordinate Page Verified");
    }

}
