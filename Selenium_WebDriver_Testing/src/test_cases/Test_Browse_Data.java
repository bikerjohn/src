package test_cases;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.Pilr_CoordinatePage;
import page_objects.Pilr_DataViewer;
import page_objects.Query_Project_Data;
import page_objects.Time_Wait;

public class Test_Browse_Data extends AbstractTestCase {
	Query_Project_Data objProjectData;
	Pilr_CoordinatePage objCoordinatePage;
	Pilr_DataViewer objDataViewer;
	Time_Wait objTimeWait;
	public String parentWindow;
	
	//select the Browse Data option on the Coordinate Page
	@Test
	public void test_Select_Data_Browser(){
		objProjectData = new Query_Project_Data(driver);
		objCoordinatePage = new Pilr_CoordinatePage(driver);
		Assert.assertTrue(objCoordinatePage.getcoordinatePageWelcome().toLowerCase()
				.contains("coordinate participants and data"));
		objCoordinatePage.browseData();		
	}
	
	@Test
	//complete the data query form (enrolled, daterange)
	public void test_Fill_Form_and_Launch_DataViewer(){
		objProjectData = new Query_Project_Data(driver);
		objTimeWait = new Time_Wait();
		objProjectData.selectGroup();
		parentWindow = driver.getWindowHandle();
		System.out.println("current window = " + parentWindow);
		objProjectData.selectDateRange(objtestvars.get_dv_Start_Date(), 
				objtestvars.get_dv_End_Date());
		objProjectData.selectApplyButton();
		objProjectData.selectSearch();
		Assert.assertTrue(objProjectData.getSummaryResults().toLowerCase()
				.contains("search results"));
		objProjectData.launchDataViewer();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		System.out.println("[Test Object]Fill Reporting Date Range");
	}
	
	@Test
	//verify that the Dataviewer is working ok
	public void test_Data_Viewer_Functionality(){
		objProjectData = new Query_Project_Data(driver);
		objDataViewer = new Pilr_DataViewer(driver);
		Assert.assertTrue(objDataViewer.getDVWelcome().toLowerCase()
				.contains("pilrhealth:mobile:survey_data"));
		objTimeWait.Duration(2000);
		objDataViewer.filter_Event_Type();
		System.out.println("[Test Object]Open Data Viewer");
	}
	
	@Test
	//verify the download csv function
	public void test_Download_CSV_File(){
		objDataViewer = new Pilr_DataViewer(driver);
		objTimeWait.Duration(1000);
		objDataViewer.download_File();
	}
	
	@Test
	//close the data viewer window
	public void test_close_Data_Viewer(){
		objDataViewer = new Pilr_DataViewer(driver);
		objDataViewer.click_Done();
		driver.switchTo().window(parentWindow); 
	}
	@Test
	//select column and filter by "survey"
	public void test_DV_Filter_Column(){
		objDataViewer = new Pilr_DataViewer(driver);
		
	}
}
