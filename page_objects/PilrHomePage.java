package page_objects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class PilrHomePage {
	WebDriver driver;
	 
	   By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
	 
	     
	 
	   public PilrHomePage(WebDriver driver){
	 
	       this.driver = driver;
	 
	   }
	   
	     
	 
	   //Get the User name from Home Page
	 
	      public String getHomePageWelcome(){
	 
	        return    driver.findElement(homePageWelcome).getText();
	 
	       }
	      
}

