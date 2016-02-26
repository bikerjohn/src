package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Add_Instrument_Modal {
	WebDriver driver;
	By addInstrumentWelcome = By.cssSelector("h4");
	By selectInstrument = By.cssSelector("div[id='select2-drop-mask']");
	By addButton = By.cssSelector("button[id='save']");
	
	public Add_Instrument_Modal(WebDriver driver){
		this.driver = driver;
	}
		
	//return welcome message
	public String getAddInstrumentWelcome(){
		return driver.findElement(addInstrumentWelcome).getText();
	}
	
	//select Add Instrument drop down box NOT CURRENTLY in USE
	public void selectInstrument(){
		driver.findElement(selectInstrument).click();
	}
	
	//click the add button to save the Instrument into the default template
	public void addInstrument(){
		driver.findElement(addButton).click();
	}
}
