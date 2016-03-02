package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_GroupPage {
	WebDriver driver;
	
	//Need locators for 
	By GroupPageWelcome = By.cssSelector("h1");
	
	//Participant Group
	//Template Assignment
	
	public Pilr_GroupPage(WebDriver driver){
		 
	       this.driver = driver;
	   }
	//Get the Create Participant Welcome
    public String getGroupPageWelcome(){
        return    driver.findElement(GroupPageWelcome).getText();
    }
    
   

}
