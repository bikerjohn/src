package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_ParticipantPage {
	WebDriver driver;
	 
	   By participantPageWelcome = By.cssSelector("h1");
	   By scheduleParticipant = By.cssSelector("a[id='startDateParticipantActivePeriod']");
	   

	   public Pilr_ParticipantPage(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Coordinate Page Welcome
	    public String getparticipantPageWelcome(){
	        return    driver.findElement(participantPageWelcome).getText();
	    }
	    //schedule the participant active period
	    public Schedule_Participant_Modal select_Participant_Schedule(){
	    	driver.findElement(scheduleParticipant).click();
	    	return new Schedule_Participant_Modal(driver);
	    }
}
