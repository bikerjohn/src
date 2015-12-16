package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PilrLogin {
	 
	   WebDriver driver;
	 
	   By PilrName = By.id("username");
	   By Pilrpassword = By.id("password");
	   By PageTitle =By.cssSelector("h4.header.blue.lighter.bigger");
	   By login = By.id("submit");
	   By Pilrregister = By.id("register");
	   By PilrPwdreset = By.id("forgot");
	 
	     
	 
	   public PilrLogin(WebDriver driver){
	        this.driver = driver;	 
	    }
	 
	    //Set user name in textbox
	    public void setUserName(String strUserName){
	        driver.findElement(PilrName).clear();
	    	driver.findElement(PilrName).sendKeys(strUserName);	 
	    }
	 
	    //Set password in password textbox
	    public void setPassword(String strPassword){
	        driver.findElement(Pilrpassword).clear(); 
	    	driver.findElement(Pilrpassword).sendKeys(strPassword);	 
	    }
	 
	     //Click on login button	 
	    public void clickLogin(){
	    	driver.findElement(login).click();
	    }
	 
	    //Get the title of Login Page
	    public String getPageSource(){
	    	return    driver.findElement(PageTitle).getText();
	    }
	 
	    public void loginToPilr(String strUserName,String strPassword){
	    	//Fill user name
	    	this.setUserName(strUserName);
	    	
	    	//Fill password
	    	this.setPassword(strPassword);
	 
	       //Click Login button
	    	this.clickLogin();   
	    	System.out.println("[Page Object]Login to Pilr");
	    }
	    
	    public void FailedloginToPilr(String strUserName, String strPassword) {
    		loginToPilr(strUserName, strPassword);
	    }
	    
	    public String getErrorMessage() {
	    	return driver.findElement(By.cssSelector("div.alert.alert-info")).getText();
	    }	 
	    
	    public Pilr_RegisterPage registerAsNewUser(){
	    	//Click register text link
	    	driver.findElement(Pilrregister).click();
	    	return new Pilr_RegisterPage(driver);
	    }
	    
	    public void pwdReset(){
	    	//Click register text link
	    	driver.findElement(PilrPwdreset).click();
	    }
}

