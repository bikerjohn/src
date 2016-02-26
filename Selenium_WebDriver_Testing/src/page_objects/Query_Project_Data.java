package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Query_Project_Data {
	WebDriver driver;
	By queryDataWelcome = By.cssSelector("i.icon-double-angle-right");
	By selectGroup = By.cssSelector("select[id='grpField']");
	By datePicker = By.cssSelector("input[name='dateRange']");
	By dateStart = By.cssSelector("input[name='daterangepicker_start']");
	By dateEnd = By.cssSelector("input[name='daterangepicker_end']");
	By applyButton = By.cssSelector("button[class='applyBtn btn btn-sm btn-success']");
	By selectEnrolled = By.cssSelector("option[value='template_assignments_enrolled']");
	By searchButton = By.cssSelector("button[id='searchBtn']");
	By divSummaryResults = By.cssSelector("div h4");
	By launchDataViewer = By.cssSelector("i[class='icon-share']");
	By dv_Survey_Code = By.cssSelector("input[id='search.data.survey_code']");
	By dv_Survey_EventType	= By.cssSelector("input[id='search.data.event_type']");
	By dv_Welcome = By.cssSelector("li.active");
	private String startDate, endDate;
	
	
	public Query_Project_Data(WebDriver driver){
		this.driver = driver;
	}
	
	//provide the welcome message
	public String getQueryWelcome(){
		return driver.findElement(queryDataWelcome).getText();
	}
	
	//select the Date Picker Group field and pick the group
	public void selectGroup(){
		driver.findElement(selectGroup).click();
		driver.findElement(selectEnrolled).click();
	}
	
	//select the date range field and set the date ranges
	public void selectDateRange(String strtDate, String ndDate){
		this.startDate = strtDate;
		this.endDate = ndDate;
		driver.findElement(datePicker).click();
		setStartDate(startDate);
		setEndDate(endDate);
	}
	
	//click the apply button to set the data picker date range
	public void selectApplyButton(){
		driver.findElement(applyButton).click();
	}
	
	//click the search button to retrieve the data
	public void selectSearch(){
		driver.findElement(searchButton).click();
	}
	
	//set the start date for the date range
	public void setStartDate(String startDt){
		driver.findElement(dateStart).clear();
		driver.findElement(dateStart).sendKeys(startDt);
	}
	
	//set the end date for the date range
	public void setEndDate(String endDt){
		driver.findElement(dateEnd).clear();
		driver.findElement(dateEnd).sendKeys(endDt);
	}
	
	//Summary Results Div Showing (result of the search key)
	public String getSummaryResults(){
		return driver.findElement(divSummaryResults).getText();
	}
	
	//launch dataviewer by clicking icon
	public Pilr_DataViewer launchDataViewer(){
		driver.findElement(launchDataViewer).click();
		return new Pilr_DataViewer(driver);
	}
		
	//switch to the DataViewer Tab
	public void switch_Tabs(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	}
	
}
