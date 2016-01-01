package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_Builder_Page {
	WebDriver driver;
	String emaconfig = "Test Config";
	String project = "test_project";
	By ebuilderPageWelcome = By.cssSelector("small");
	By emaconfigBuilder = By.linkText(emaconfig);
	By addConfig = By.cssSelector("a[href='/project/project_name/emaOtsConfig/createConfig']");
	
	public Pilr_Builder_Page(WebDriver driver){
		 
	       this.driver = driver;	       
	   }
	//Get the Builder Page Welcome
    public String getBuilderPageWelcome(){
        return    driver.findElement(ebuilderPageWelcome).getText();
    }
    //Select the EMA Configuration
    //need to build a ConfigBuilder Page Object
    //Select an existing EMA Config to Open the Config Builder Page
    public Pilr_Config_Builder selectEMAConfig(String emaconfig) {
      this.emaconfig = emaconfig;
      By emaconfigBuilder = By.linkText(emaconfig);
  	  driver.findElement(emaconfigBuilder).click();
  	  System.out.println("[Page Object]Select EMA Config");
  	  return new Pilr_Config_Builder(driver);
    }	
    //Create a new EMA Configuration
    public Builder_EMAConfig_Page addEMAConfig(String project_name){
    	this.project = project_name;
    	By addConfig = By.cssSelector("a[href='/project/" + project + "/emaOtsConfig/createConfig']");
    	driver.findElement(addConfig).click();
    	return new Builder_EMAConfig_Page(driver);
    }
  
}