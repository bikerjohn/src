package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_EMA_App_Home {
	WebDriver driver;
	
	By EmaappPageWelcome = By.cssSelector("small");
	By SurvResponseLink = By.linkText("Survey Responses");
	By ebuilderLink = By.linkText("Builder");
	
	public Pilr_EMA_App_Home(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Coordinate Page Welcome
    public String getEMAAppPageWelcome(){
        return    driver.findElement(EmaappPageWelcome).getText();
    }
    //Navigate to the Survey Response Page
    public Pilr_Survey_ResponsePage selectSurvResponse() {
  	  driver.findElement(SurvResponseLink).click();
  	  System.out.println("[Page Object]Select Survey Reponse Link");
  	  return new Pilr_Survey_ResponsePage(driver);
    }
  //Navigate to the EMA Builder Page
    public Pilr_Builder_Page selectEMABuilder() {
  	  driver.findElement(ebuilderLink).click();
  	  System.out.println("[Page Object]Select EMA Builder Link");
  	  return new Pilr_Builder_Page(driver);
    }
	   
}
