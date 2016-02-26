package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Survey_Builder {
	WebDriver driver;
	private String surv_name="Test Survey";
	By survBuilderWelcome = By.cssSelector("b[class='green']");
	By selectSurvey = By.linkText(surv_name);
	By addSection = By.cssSelector("i[class='icon icon-plus']");
	By addCard = By.linkText("Add a Card");
	String sec_refid = "123";
	//need a selector for the trigger editor
	//need a selector for the App Tabs cards (edit/delete)
	public Pilr_Survey_Builder(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Survey_Builder Page Welcome
    public String getsurveyBuilderWelcome(){
        return    driver.findElement(survBuilderWelcome).getText();
    }
    
    //Create Section Method
    public Section_Modal create_Section(){
    	driver.findElement(addSection).click();
    	return new Section_Modal(driver);   	
    }
    //Create Card Method
    public Card_Modal create_Card(String ref_id){
    	this.sec_refid = ref_id;
    	driver.findElement(By.cssSelector("input[class='section'][value='" + ref_id + "']"));
    	//By addCard = By.cssSelector("a[onclick='isChangesSaved();'][href='#addSurveyCardModal - " + sec_refid + "']");
    	driver.findElement(addCard).click();
    	return new Card_Modal(driver);
    }
}

