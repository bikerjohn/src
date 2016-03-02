package page_objects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Schedule_Participant_Modal {
	WebDriver driver;
	By scheduleParticipantWelcome = By.cssSelector("h4");
	By periodStartDate = By.cssSelector("input[id='startDateString']");
	By saveButton = By.cssSelector("button[id='save']");
	private String cur_Date;
	
	public Schedule_Participant_Modal(WebDriver driver){
		this.driver = driver;
	}
	//get the modal welcome message
	public String get_Schedule_Participant_Welcome(){
		return driver.findElement(scheduleParticipantWelcome).getText();
	}
	//fill the text box with the current date and hit the save button
	public Pilr_ParticipantPage set_Participant_Start_Date(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateobj = new Date();
	    cur_Date = df.format(dateobj);
		driver.findElement(periodStartDate).click();
		driver.findElement(periodStartDate).sendKeys(cur_Date);
		driver.findElement(periodStartDate).sendKeys(Keys.TAB);
		driver.findElement(saveButton).click();
		return new Pilr_ParticipantPage(driver);
	}
}
