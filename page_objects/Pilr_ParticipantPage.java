package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_ParticipantPage {
	WebDriver driver;
	 
	   By participantPageWelcome = By.cssSelector("h1");

	   public Pilr_ParticipantPage(WebDriver driver){
			 
	       this.driver = driver;
	   }
	   
	 	//Get the Coordinate Page Welcome
	    public String getparticipantPageWelcome(){
	        return    driver.findElement(participantPageWelcome).getText();
	    }
}
