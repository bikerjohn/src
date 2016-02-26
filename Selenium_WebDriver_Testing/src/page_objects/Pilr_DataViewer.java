package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Pilr_DataViewer {
	WebDriver driver;
	
	public Pilr_DataViewer(WebDriver driver){
		this.driver = driver;
	}
	
	By dv_Survey_Code = By.cssSelector("input[name='search.data.survey_code']");
	By dv_Survey_EventType	= By.cssSelector("input[name='search.data.event_type']");
	By dv_Welcome = By.cssSelector("i[class='icon-double-angle-right']");
	By dv_click_EventType = By.linkText("event_type");
	By dv_window_Close = By.cssSelector("a[href='javascript:window.close();']");
	By dv_column_Button = By.cssSelector("button[id='dataTableColumns']");
	By dv_metadata_timestamp_CB = By.cssSelector("input[name='view.metadata.timestamp']");
	By dv_session_CB = By.cssSelector("input[name='view.data.session']");
	By dv_download_Button = By.cssSelector("button[id='dataTableDownload']");
	By dv_download_CSV = By.cssSelector("a[class='csv']");
	
	//check dataviewer window
	public String getDVWelcome(){
		return driver.findElement(dv_Welcome).getText();
	}
		
	//access survey code column and force a sort
	public void filter_Event_Type(){
		driver.findElement(dv_Survey_EventType).click();
		driver.findElement(dv_Survey_EventType).clear();
		driver.findElement(dv_Survey_EventType).sendKeys("survey");
		driver.findElement(dv_click_EventType).click();
	}
	
	//select to download a csv
	public void download_File(){
		driver.findElement(dv_download_Button).click();
		driver.findElement(dv_download_CSV).click();
	}
	
	//select columns to drop out of the view
	public void uncheck_Columns(){
		driver.findElement(dv_column_Button).click();
		driver.findElement(dv_metadata_timestamp_CB).click();
		driver.findElement(dv_session_CB).click();
	}
	
	//close data viewer window by hitting "Done" button
	public void click_Done(){
		driver.findElement(dv_window_Close).click();
	}
}
