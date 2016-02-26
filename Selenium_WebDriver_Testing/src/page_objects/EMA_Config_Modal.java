package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EMA_Config_Modal {
	WebDriver driver;
	By emaModalWelcome = By.cssSelector("h4");
	By radioButton = By.cssSelector("input[name='value']");
	By saveButton = By.cssSelector("button[id='save']");
	
	public EMA_Config_Modal(WebDriver driver){
		this.driver = driver;
	}
	
	//return welcome message
	public String getModalWelcome(){
		return driver.findElement(emaModalWelcome).getText();
	}
	
	//click radio button to select ema config (for single option)
	public void clickRadioButton(){
		driver.findElement(radioButton).click();
	}
	
	//click save button to save changes
	public void clickSave(){
		driver.findElement(saveButton).click();
	}
}
