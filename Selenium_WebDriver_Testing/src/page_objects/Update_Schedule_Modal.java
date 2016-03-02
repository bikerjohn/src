package page_objects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Update_Schedule_Modal {
	WebDriver driver;
	By scheduleModalWelcome = By.cssSelector("div[class='table-header']");
	By inputDateStart = By.cssSelector("input[id='startDateString']");
	By saveButton = By.cssSelector("input[id='Save']");
	By closeModal = By.cssSelector("button[data-dismiss='modal']");
	private String cur_Date;
	
	public Update_Schedule_Modal(WebDriver driver){
		this.driver = driver;
	}
	
	//return the modal welcome message
	public String getScheduleModalWelcome (){
		return driver.findElement(scheduleModalWelcome).getText();
	}
	//select the Active Period start date and save the information
	public void Schedule_Active_Period(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateobj = new Date();
	    cur_Date = df.format(dateobj);
		driver.findElement(inputDateStart).click();
		driver.findElement(inputDateStart).sendKeys(cur_Date);
		driver.findElement(saveButton).click();
	}
	//dismiss the modal after the schedule is set
	public void Dismiss_Schedule_Modal(){
		driver.findElement(closeModal).click();
	}
}
