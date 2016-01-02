package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Add_Survey_Modal {
	WebDriver driver;
	By Add_Survey_Modal_Welcome = By.cssSelector("div[class='table-header']");
	By Survey_Name = By.cssSelector("input[name='name']");
	By Survey_Description = By.cssSelector("textarea[name='description']");
	By Create_Survey = By.cssSelector("button[name='create']");
	String SurveyName = "test_survey";
	String SurveyDescription = "this is a test description";
	
	public Add_Survey_Modal(WebDriver driver){
		this.driver = driver;
	}
	public String getSurvey_Modal_Welcome(){
		return driver.findElement(Add_Survey_Modal_Welcome).getText();
	}
	  //Set survey name in textbox
    public void setSurveyName(String survName){
        driver.findElement(Survey_Name).clear();
    	driver.findElement(Survey_Name).sendKeys(SurveyName);	 
    }
    //Set the survey description in the textarea
    public void setSurveyDescription(String survDescription){
    	driver.findElement(Survey_Description).clear();
    	driver.findElement(Survey_Description).sendKeys(SurveyDescription);	
    }
    //This is the add survey method
    public Pilr_Survey_Builder addSurvey(String survName, String survDescription){
    	this.SurveyName = survName;
    	this.SurveyDescription = survDescription;
    	this.setSurveyName(survName);
    	this.setSurveyDescription(survDescription);
    	driver.findElement(Create_Survey).click();
    	return new Pilr_Survey_Builder(driver);
    }
}
