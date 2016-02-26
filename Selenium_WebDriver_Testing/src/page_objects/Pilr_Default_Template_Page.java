package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Default_Template_Page {
	WebDriver driver;
	By deftempWelcome = By.cssSelector("i[class='icon-double-angle-right']");
	By addInstrument = By.cssSelector("a[id='newInstrument']");
	By createNewSetting = By.cssSelector("input[title='Create new setting']");
	By successInstrument = By.cssSelector("div[id='successClose']");
	private String messageText;
	
	public Pilr_Default_Template_Page(WebDriver driver){
		this.driver = driver;
	}
	
	//get welcome text
	public String getDefTemplateWelcome(){
		return driver.findElement(deftempWelcome).getText();
	}
	
	//click add instrument
	public Add_Instrument_Modal actionsAddInstrument(){
		driver.findElement(addInstrument).click();
		return new Add_Instrument_Modal(driver);
	}
	public EMA_Config_Modal selectInstrument(){
		driver.findElement(addInstrument).click();
		return new EMA_Config_Modal(driver);
	}
	
	//verify instrument added successfully
	public void verifyInstrument(){
		messageText = driver.findElement(successInstrument).getText();
	}

}
