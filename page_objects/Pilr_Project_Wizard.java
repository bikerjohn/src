package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Project_Wizard {
	WebDriver driver;
	private String projName="test_project";
	By projectWizardWelcome = By.cssSelector("h4");
	By projectName = By.cssSelector("input[id*='name']");
	By projSubmit = By.cssSelector("button[id*='next']");
	public Pilr_Project_Wizard(WebDriver driver){
		this.driver = driver;
	}
	//Get the Project Wizard Page Welcome
    public String getProjWizardPageWelcome(){
        return    driver.findElement(projectWizardWelcome).getText();
    }
    //set the project name in the input field
    public void setProjectName(String projName){
        driver.findElement(projectName).clear();
    	driver.findElement(projectName).sendKeys(projName);	 
    }
    //select the submit button
    public void clickSubmit(){
    	driver.findElement(projSubmit).click();
    }
    //create the project and move to the Project Config Options Page
    public Project_Wizard_Config_Options createProject(String projectName){
    	this.setProjectName(projectName);
    	this.clickSubmit();
    	return new Project_Wizard_Config_Options(driver);
    }
}
