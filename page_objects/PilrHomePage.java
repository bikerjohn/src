package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test_cases.TestVars;

public class PilrHomePage {
	WebDriver driver;
	 
		private String project = "DualCohortStudy (OWNER)";
		By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
		By PilrProject = By.linkText(project);
	     
	 
	   public PilrHomePage(WebDriver driver){
	 
	       this.driver = driver;
	       
	   }
	 
	   //Get the User name from Home Page
	      public String getHomePageWelcome(){
	        return    driver.findElement(homePageWelcome).getText();
	       }
	      
	      //Select a project to work on
	      public Pilr_CoordinatePage selectProject(String prjct) {
	    	  this.project = prjct;
		      this.PilrProject = By.linkText(project);
		      System.out.println("[Page Object]Select Project");
	    	  driver.findElement(PilrProject).click();
	    	  return new Pilr_CoordinatePage(driver);
	      }	     
}

