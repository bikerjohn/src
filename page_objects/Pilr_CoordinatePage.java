package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_CoordinatePage {
	WebDriver driver;
	 
	   By coordinatePageWelcome = By.cssSelector("i.icon-double-angle-right");
	   By PilrProject = By.linkText("PiLRHealth Auto QA Test Org (OWNER)");
	 
	     
	 
	   public Pilr_CoordinatePage(WebDriver driver){
	 
	       this.driver = driver;
	   }
	   
	 //Get the Coordinate Page Welcome
	      public String getcoordinatePageWelcome(){
	        return    driver.findElement(coordinatePageWelcome).getText();
	       }
}
