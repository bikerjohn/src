package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Section_Modal {
	WebDriver driver;
	By Section_Name = By.cssSelector("input[name='name']");
	By Description = By.cssSelector("textarea[name='description']");
	By sectionModalWelcome = By.cssSelector("div[class='table-header']"); 
	By Create_Button = By.cssSelector("button[name='create']");
	By Refid = By.cssSelector("input[name='code']");
	String section_name = "test name";
	String section_description = "section description";
	String section_refid = "123";
	
	public Section_Modal(WebDriver driver){
		this.driver = driver;
	}
	//return the modal welcome message
	public String getsectionModalWelcome(){
	       return    driver.findElement(sectionModalWelcome).getText();
	}
	//create the Section by filling in the name, description, and clicking the save button
	public void createSection(String sec_name, String sec_description){
		this.section_name = sec_name;
		this.section_description = sec_description;
		setSection_Name(section_name);
		setSection_Description(section_description);	
	}
	//fill the Section Name field
	public void setSection_Name(String section_name){
		driver.findElement(Section_Name).sendKeys(section_name);
	}
	//fill the Section Description field
	public void setSection_Description(String section_description){
		driver.findElement(Description).sendKeys(section_description);
	}
	//get the section reference id from the input screen
	public String getRefid(){
		this.section_refid=driver.findElement(Refid).getAttribute("value");
		return section_refid;
	}
	//save the new Section
	public Pilr_Survey_Builder saveSection(){
		driver.findElement(Create_Button).click();
		return new Pilr_Survey_Builder(driver);
	}
}
