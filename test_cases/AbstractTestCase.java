package test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;

public class AbstractTestCase {

	protected WebDriver driver;
	TestVars objtestvars;

	public AbstractTestCase() {
		super();
	}

	@BeforeTest
	public void setup() {
	
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://qa.pilrhealth.com/");
	    objtestvars = new TestVars();
	    final Logger log = Logger.getLogger(AbstractTestCase.class);
	
	}
	@AfterTest

    public void tearDown() throws Exception {
    	driver.quit();
      
      
    }

}