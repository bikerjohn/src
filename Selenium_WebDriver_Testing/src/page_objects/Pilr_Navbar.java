package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Navbar {
	WebDriver driver;
	
	By Navbar_useraccount = By.id("yourAccountDropdown");
	By Account_option = By.id("logout");
	
	public Pilr_Navbar(WebDriver driver){
		this.driver = driver;
	}
	//Logout of the Home page
    public void clickLogout(){
   	 driver.findElement(Navbar_useraccount).click();
   	 driver.findElement(Account_option).click(); 
    }
}
