package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Project_Design {
	WebDriver driver;
	By projectDesignWelcome = By.cssSelector("i[class='icon-double-angle-right']");
	By defaultTemplate = By.cssSelector("a[id='showDefaultTemplate']");
	
	public Pilr_Project_Design(WebDriver driver){
		this.driver = driver;
	}

	//return Project Design Page Welcome Message
	public String getProjectDesignWelcome(){
		return driver.findElement(projectDesignWelcome).getText();
	}
	
	//open the Default Template Page
	public Pilr_Default_Template_Page Select_Default_Template(){
		driver.findElement(defaultTemplate).click();
		return new Pilr_Default_Template_Page(driver);
	}

}
