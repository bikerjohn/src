package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project_Wizard_Config_Options {
	WebDriver driver; 
	By configOptionsWelcome = By.cssSelector("h3[class='lighter block green']");
	By buildFromScratch = By.cssSelector("input[id='nextStep_doItYourself']");
	By nextButton = By.cssSelector("button[id='next']");
	
	public Project_Wizard_Config_Options(WebDriver driver){
		this.driver = driver;
	}
	//get page welcome text
	public String getConfigOptionsWelcome(){
        return    driver.findElement(configOptionsWelcome).getText();
    }
	//select the build from scratch radio button
	public void selectBuildFromScratch(){
		driver.findElement(buildFromScratch).click();
	}
	//select the "next" button and move to the Project Wizard Duration page
	public Project_Wizard_Duration selectNext(){
		//WebElement nextButton = driver.findElement(By.linkText("next"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
  	  	je.executeScript("arguments[0].scrollIntoView(true);",
  	  	driver.findElement(By.cssSelector("button[id='next']")));
  	  	driver.findElement(nextButton).click();
		
		return new Project_Wizard_Duration(driver);
	}
}
