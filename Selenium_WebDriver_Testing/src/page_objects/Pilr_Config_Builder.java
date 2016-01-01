package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Config_Builder {
	WebDriver driver;
	private String surv_name="Test Survey";
	By configbuilderPageWelcome = By.cssSelector("small");
	By ProjectSurvey = By.linkText(surv_name);
	
	public Pilr_Config_Builder(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Config_Builder Page Welcome
    public String getconfigbuilderPageWelcome(){
        return    driver.findElement(configbuilderPageWelcome).getText();
    }
    //Open the Survey Builder by selecting a survey
    public Pilr_Survey_Builder selectSurvey(String surv_name) {
    	this.surv_name = surv_name;
    	By ProjectSurvey = By.linkText(surv_name);
  	  	driver.findElement(ProjectSurvey).click();
  	  	System.out.println("[Page Object]Select Survey");
  	  	return new Pilr_Survey_Builder(driver);
    }	 
    
    //Add a section for the survey (all of this content needs to be in testvars
    //Add a card to the section
}
