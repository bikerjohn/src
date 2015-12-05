package page_objects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class PilrHomePage {
	WebDriver driver;
	 
	   By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
	   By PilrProject = By.linkText("Delete EMA Config Test (OWNER)");
	 
	     
	 
	   public PilrHomePage(WebDriver driver){
	 
	       this.driver = driver;
	   }
	 
	   //Get the User name from Home Page
	      public String getHomePageWelcome(){
	        return    driver.findElement(homePageWelcome).getText();
	       }
	      
	      //Select a project to work on
	      public Pilr_CoordinatePage selectProject() {
	    	  driver.findElement(PilrProject).click();
	    	  return new Pilr_CoordinatePage(driver);
	      }	      
}

