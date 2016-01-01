package page_objects;
import java.lang.management.ManagementFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import test_cases.TestVars;

public class PilrHomePage {
	WebDriver driver;
	 
		private String project = "DualCohortStudy (OWNER)";
		private String organization = "test_org";
		By homePageWelcome = By.cssSelector("i.icon-double-angle-right");
		By PilrProject = By.linkText(project);
		By PilrOrg = By.linkText(organization);
	     
	   public PilrHomePage(WebDriver driver){
	 
	       this.driver = driver;
	       
	   }
	 
	   //Get the User name from Home Page
	      public String getHomePageWelcome(){
	        return    driver.findElement(homePageWelcome).getText();
	       }
	      
	      //Select a project to work on
	      public Pilr_CoordinatePage selectProject(String prjct) {
	    	  this.project = prjct + " (OWNER)";
		      this.PilrProject = By.linkText(project);
		      System.out.println("[Page Object]Select Project");
		      WebElement element = driver.findElement(By.linkText(project));
	    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    	  
	    	  driver.findElement(By.linkText(project)).click();
	    	  return new Pilr_CoordinatePage(driver);
	      }
	      //Select an organization to work on
	      public Pilr_Org_Page selectOrganization(String org){
	    	  this.organization = org;
	    	  this.PilrOrg = By.linkText(organization);
	    	  WebElement PilrOrg = driver.findElement(By.linkText(organization));
	    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PilrOrg);
	    	  driver.findElement(By.linkText(organization)).click();
	    	  return new Pilr_Org_Page(driver);
	      }
	      
}

