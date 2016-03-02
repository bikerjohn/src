package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Create_Participant {
	WebDriver driver;
	
	//Need locators for 
	By newParticipantPageWelcome = By.cssSelector("h4");
	By participantCode = By.cssSelector("input[id='code']");
	By participantDescription = By.cssSelector("input[id='description']");
	By saveButton = By.cssSelector("input[id='save']");
	private String part_Description;
	private String part_Code;
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
    //fill the form and hit the save key (need Strings for Code and Description)
    public Pilr_ParticipantPage completeCreateParticipantForm(String p_Code, String p_Description){
    	this.part_Code = p_Code;
    	this.part_Description = p_Description;
    	driver.findElement(participantCode).click();
    	driver.findElement(participantCode).sendKeys(p_Code);
    	driver.findElement(participantDescription).click();
    	driver.findElement(participantDescription).sendKeys(p_Description);
    	driver.findElement(saveButton).click();
    	return new Pilr_ParticipantPage(driver);
    }

}
