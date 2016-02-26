package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Project_Settings_Page {
	WebDriver driver;
	private String instr_def;
	By projectSettingsWelcome = By.cssSelector("i.icon-double-angle-right");
	By projectSettingsInstrSuccess = By.cssSelector("div[class='alert alert-success']");
	By instrumentImport = By.cssSelector("a[data-toggle='modal'][href='#importDefinitionModal']");
	By projectDesignNav = By.cssSelector("a[id='navConfigurationDesign']");
	
	public Pilr_Project_Settings_Page(WebDriver driver){
		this.driver = driver;
	}
	//Get the Project Settings Page Welcome
    public String getprojectSettingsWelcome(){
        return    driver.findElement(projectSettingsWelcome).getText();
    }
  //Get the Project Settings Instrument Settings Success Greeting
    public String getprojectSuccessMsg(){
        return    driver.findElement(projectSettingsInstrSuccess).getText();
    }
    //Select import option in the Instrument block
    public Project_Import_Modal selectInstrumentImport(){
    	driver.findElement(instrumentImport).click();
    	return new Project_Import_Modal(driver);
    }
    
    //Select Project Design
    public Pilr_Project_Design nav_Project_Design(){
    	driver.findElement(projectDesignNav).click();
    	return new Pilr_Project_Design(driver);
    }
}
