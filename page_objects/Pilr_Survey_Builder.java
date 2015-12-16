package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Survey_Builder {
	WebDriver driver;
	private String surv_name="Test Survey";
	By survBuilderWelcome = By.cssSelector("b.green");
	By selectSurvey = By.linkText(surv_name);
	//need a selector for the trigger editor
	//need a selector for the App Tabs cards (edit/delete)
	public Pilr_Survey_Builder(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Survey_Builder Page Welcome
    public String getsurveyBuilderWelcome(){
        return    driver.findElement(survBuilderWelcome).getText();
    }
}

