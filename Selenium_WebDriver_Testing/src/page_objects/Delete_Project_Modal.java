package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Project_Modal {
	WebDriver driver;
	By deleteProjectWelcome = By.cssSelector("div[class='modal-body']");
	By confirmButton = By.cssSelector("button[id='modalConfirm']");
	
	public Delete_Project_Modal(WebDriver driver){
		this.driver = driver;
	}
	
	//return the modal welcome message (in the header)
	public String get_Delete_Project_Welcome(){
		return driver.findElement(deleteProjectWelcome).getText();
	}
	//click the delete project button (confirm the delete)
	public Pilr_Org_Page click_Confirm_Delete(){
		driver.findElement(confirmButton).click();
		return new Pilr_Org_Page(driver);
	}
}
