package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_ForgotPwd {
	WebDriver driver;
	By forgotPwdPageWelcome = By.cssSelector("h4.header.red.lighter.bigger");
	
	public Pilr_ForgotPwd(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;

	}
	// return verification text
	public String getRegisterPageWelcome(){
		 
        return    driver.findElement(forgotPwdPageWelcome).getText();
 
       }
	
}
