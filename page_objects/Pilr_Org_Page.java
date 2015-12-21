package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_cases.TestVars;
import java.time.LocalDateTime;

public class Pilr_Org_Page {
	WebDriver driver;
	TestVars objtestvars; 
	By orgPageWelcome = By.cssSelector("h1");
	By createProject = By.cssSelector("a[href*='newProject']");
	
	public Pilr_Org_Page(WebDriver driver){
		this.driver = driver;
	}
	
	//Get the Org Page Welcome
	public String getOrgPageWelcome(){
        return    driver.findElement(orgPageWelcome).getText();
    }
	
	//Create a new project by selecting the +New link
	public Pilr_Project_Wizard createProject(){
		driver.findElement(createProject).click();
		return new Pilr_Project_Wizard(driver);
	}
}

