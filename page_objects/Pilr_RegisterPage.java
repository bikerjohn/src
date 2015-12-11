package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_RegisterPage {
	WebDriver driver;
	By registerPageWelcome = By.cssSelector("div#signup-widget-main");
	By clickLoginReturn = By.id("back-to-login-2");
	By emailaddress = By.xpath("(//input[@id='email'])[2]");
	By userName = By.name("username");
	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
	By Organization = By.id("organization");
	By Password = By.name("password");
	By rptPassword = By.id("confirmPassword");
	By termsCheckbox = By.name("acceptTerms");
	By registerButton = By.cssSelector("div.clearfix > #register");
	By registerSuccess = By.id("signup-widget-main");
	
	
	public Pilr_RegisterPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;

	}
	
	//locate Registration Page Welcome Text and return to Test Object
	public String getRegisterPageWelcome(){
		 
        return    driver.findElement(registerPageWelcome).getText();
 
       }
	
	public void registerNewuser(String strEmail,String strUserName,String strfirstName, String strlastName,
			String strOrganization, String strPassword, String strrptPassword){
    	//set the form values
		this.setemailaddress(strEmail);
    	this.setUsername(strUserName);
    	this.setFirstname(strfirstName);
    	this.setLastname(strlastName);
    	this.setOrganization(strOrganization);
    	this.setPassword(strPassword);
    	this.setrptPassword(strrptPassword);
 
    	this.clickacceptEULA();   
    	this.clickregisterButton();
    	System.out.println("[Page Object]Register as New User");
    }
	
	//implement the methods associated with filling out the registration form
	//Set email address
	 public void setemailaddress(String strEmail){
		 
		 driver.findElement(emailaddress).clear();
		 driver.findElement(emailaddress).sendKeys(strEmail);
	 
	 }
	 
	 //Set username 
	 public void setUsername(String struserName){
	 
		 driver.findElement(userName).clear(); 
		 driver.findElement(userName).sendKeys(struserName);
	 
	    }
	 //Set firstname 
	 public void setFirstname(String strfirstName){
		 
		 driver.findElement(firstName).clear(); 
		 driver.findElement(firstName).sendKeys(strfirstName);
		 
	 }
	 //Set lastname 
	 public void setLastname(String strlastName){
		 
		 driver.findElement(lastName).clear(); 
		 driver.findElement(lastName).sendKeys(strlastName);
		 
	 }
	
	 //Set organization 
	 public void setOrganization(String strOrganization){
		 
		 driver.findElement(Organization).clear(); 
		 driver.findElement(Organization).sendKeys(strOrganization);
		 
	 }
		 
	 //Set password in password textbox
	 public void setPassword(String strPassword){
	 
	    driver.findElement(Password).clear(); 
	    driver.findElement(Password).sendKeys(strPassword);
	 
	 }
	 
	 //Set repeat password in password textbox
	 public void setrptPassword(String strrptPassword){
		 
		 driver.findElement(rptPassword).clear(); 
		 driver.findElement(rptPassword).sendKeys(strrptPassword);
		 
	 }
		
	 //Click on terms of service checkbox
	 public void clickacceptEULA(){
		 driver.findElement(termsCheckbox).click();
	 }
		
	//Click on Register button
		 public void clickregisterButton(){
			 driver.findElement(registerButton).click();
		 }
	 
	 //Click on return to login button
	 public void clickLoginReturn(){
		 driver.findElement(clickLoginReturn).click();
    }
	 
	//locate Registration Success Text and return to Test Object
	public String getRegisterSubmit(){
			return    driver.findElement(registerSuccess).getText();
	 
	}
}
