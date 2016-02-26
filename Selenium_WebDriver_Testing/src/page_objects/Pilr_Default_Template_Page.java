package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Default_Template_Page {
	WebDriver driver;
	By deftempWelcome = By.cssSelector("i[class='icon-double-angle-right']");
	By addInstrument = By.cssSelector("a[id='newInstrument']");
	By createNewSetting = By.cssSelector("input[elementid='createSettingForema_otsema_configEpoch1']");
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
	//select the ema config -- open the ema config modal
	public EMA_Config_Modal selectInstrument(){
		driver.findElement(createNewSetting).click();
		return new EMA_Config_Modal(driver);
	}
	
	//verify instrument added successfully
	public String verifyInstrument(){
		return driver.findElement(successInstrument).getText();
	}

}
