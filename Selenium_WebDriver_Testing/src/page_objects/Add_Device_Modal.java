package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Add_Device_Modal {
	WebDriver driver;
	By addDeviceWelcome = By.cssSelector("h4");
	By loginID = By.cssSelector("input[id='activationName']");
	By createLogin = By.cssSelector("input[id='Create login credentials']");
	private String loginId;
	
	public Add_Device_Modal(WebDriver driver){
		this.driver = driver;
	}
	//return the modal welcome message
	public String Get_addDevice_Welcome(){
		return driver.findElement(addDeviceWelcome).getText();
	}
	//fill the login id field and hit the create button
	public Pilr_ParticipantPage createLoginID(String loginid){
		this.loginId = loginid;
		driver.findElement(loginID).click();
		driver.findElement(loginID).sendKeys(loginId);
		driver.findElement(createLogin).click();
		return new Pilr_ParticipantPage(driver);
	}

}
