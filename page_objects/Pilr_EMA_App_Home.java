package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_EMA_App_Home {
	WebDriver driver;
	
	By EmaappPageWelcome = By.cssSelector("small");
	
	public Pilr_EMA_App_Home(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Coordinate Page Welcome
    public String getEMAAppPageWelcome(){
        return    driver.findElement(EmaappPageWelcome).getText();
    }
	   
}
