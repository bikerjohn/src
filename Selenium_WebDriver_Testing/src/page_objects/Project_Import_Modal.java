package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project_Import_Modal {
	WebDriver driver;
	private String urlAddress;
	By projectImportModalWelcome = By.cssSelector("div[class='table-header']");
	By importFromURL = By.cssSelector("a[title='URL']");
	By fieldURL = By.cssSelector("input[id='importURL']");
	By importButton = By.cssSelector("button[id='next']");
	
	public Project_Import_Modal(WebDriver driver){
		this.driver = driver;
	}
	//get Import Modal Page welcome
	public String getProjectImportModalWelcome(){
        return    driver.findElement(projectImportModalWelcome).getText();
    }
	//select Import from a URL
	public void importInstrumentfromURL(String urlAddress){
		this.urlAddress = urlAddress;
		driver.findElement(importFromURL).click();
		driver.findElement(fieldURL).clear();
		driver.findElement(fieldURL).sendKeys(urlAddress);
		driver.findElement(importButton).click();
	}

}
