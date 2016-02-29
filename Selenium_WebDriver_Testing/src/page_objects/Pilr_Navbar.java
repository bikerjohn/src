package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Navbar {
	WebDriver driver;
	
	By Navbar_useraccount = By.id("yourAccountDropdown");
	By Account_option = By.id("logout");
	By projectSettingsIcon = By.cssSelector("i[class='icon-cogs']");
	By coordinateProjectIcon = By.cssSelector("i[class='icon-dashboard']");
	
	public Pilr_Navbar(WebDriver driver){
		this.driver = driver;
	}
	//Logout of the Home page
    public void clickLogout(){
   	 driver.findElement(Navbar_useraccount).click();
   	 driver.findElement(Account_option).click(); 
    }
    
    //Select the Project Settings Navbar Icon to navigate to the Project Settings Page
    public Pilr_Project_Settings_Page click_Project_Settings_Icon(){
    	driver.findElement(projectSettingsIcon).click();
    	return new Pilr_Project_Settings_Page(driver);
    }
    
    //Select the Coordinate Project Coordinate Page icon to navigate to the Coordinate Page
    public Pilr_CoordinatePage click_Project_Coordinate_Icon(){
    	driver.findElement(coordinateProjectIcon).click();
    	return new Pilr_CoordinatePage(driver);
    }
}
