package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Project_Wizard_Duration {
	WebDriver driver;
	By durationWelcome = By.cssSelector("h3[class='lighter block green']");
	By finishButton = By.cssSelector("button[id='next']");
	
	public Project_Wizard_Duration(WebDriver driver){
		this.driver = driver;
	}
		//get page welcome text
		public String getDurationWelcome(){
	        return    driver.findElement(durationWelcome).getText();
		}
		//select Finish and to the project button
		public Pilr_CoordinatePage selectFinish(){
			JavascriptExecutor je = (JavascriptExecutor) driver;
	  	  	je.executeScript("arguments[0].scrollIntoView(true);",
	  	  	driver.findElement(By.cssSelector("button[id='next']")));
	  	  	driver.findElement(finishButton).click();
			return new Pilr_CoordinatePage(driver);
		}
}
