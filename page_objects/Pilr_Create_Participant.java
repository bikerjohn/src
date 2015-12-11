package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Create_Participant {
	WebDriver driver;
	
	//Need locators for 
	By newParticipantPageWelcome = By.cssSelector("h4");
	//Participant Code
	//Description
	//Participant Group
	//Template Assignment
	
	public Pilr_Create_Participant(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Create Participant Welcome
    public String getnewparticipantPageWelcome(){
        return    driver.findElement(newParticipantPageWelcome).getText();
    }

}
