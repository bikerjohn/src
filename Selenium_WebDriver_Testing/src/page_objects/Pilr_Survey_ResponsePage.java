package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Survey_ResponsePage {
	WebDriver driver;
	By surveyResponsePageWelcome = By.cssSelector("i[class='icon-double-angle-right']");
	
	public Pilr_Survey_ResponsePage(WebDriver driver){		 
	       this.driver = driver;
	   }
	//Get the Survey_ResponsePage Welcome
    public String getSurvey_ResponsePageWelcome(){
        return    driver.findElement(surveyResponsePageWelcome).getText();
    }

}
