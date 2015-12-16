package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Builder_Page {
	WebDriver driver;
	String emaconfig = "Test Config";
	By ebuilderPageWelcome = By.cssSelector("small");
	By emaconfigBuilder = By.linkText(emaconfig);
	
	public Pilr_Builder_Page(WebDriver driver){
		 
	       this.driver = driver;	       
	   }
	//Get the Builder Page Welcome
    public String getBuilderPageWelcome(){
        return    driver.findElement(ebuilderPageWelcome).getText();
    }
    //Select the EMA Configuration
    //need to build a ConfigBuilder Page Object
    
    public Pilr_Config_Builder selectEMAConfig(String emaconfig) {
      this.emaconfig = emaconfig;
      By emaconfigBuilder = By.linkText(emaconfig);
  	  driver.findElement(emaconfigBuilder).click();
  	  System.out.println("[Page Object]Select EMA Config");
  	  return new Pilr_Config_Builder(driver);
    }	
  
}
