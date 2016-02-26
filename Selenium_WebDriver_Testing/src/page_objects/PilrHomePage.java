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
		By PilrProject = By.cssSelector("a[title='"+project+"']");
		By PilrOrg = By.linkText(organization);
		By PilrTable = By.cssSelector("table[class^='table table-responsive']");
		By PilrOrgExp = By.cssSelector("i[class='icon-chevron-right'] + *");
		By PilrChooseProj = By.cssSelector("a[title='Choose a Project']");
	     
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
		      this.PilrProject = By.partialLinkText(project);
		      System.out.println("[Page Object]Select Project");
		    //  WebElement element = driver.findElement(PilrProject);
	    	//  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    	  driver.findElement(PilrChooseProj).click();
	    	  driver.findElement(PilrProject).click();
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
	      //Expand an Org group in order to be able to select a project
	      public void expandOrg(String Org){
	    	  this.organization = Org;
	    	  this.PilrOrgExp = By.cssSelector("i[class='icon-chevron-right']");
	    	  driver.findElement(PilrTable).click();
	    	  driver.findElements(PilrOrgExp).get(1).click(); 
	      }
	      
}

