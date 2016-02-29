package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Update_Group_Modal {
	WebDriver driver;
	By updateGroupWelcome = By.cssSelector("div[class='table-header']");
	By participantStatus = By.cssSelector("select[name='groupIds']");
	By templateAssignments = By.cssSelector("select[name='groupIds']");
	By saveButton = By.cssSelector("input[id='Save']");
	By doneButton = By.cssSelector("button[data-dismiss='modal']");
	By updateSuccess = By.cssSelector("div[class='table-header']");
	private String part_status = "Enrolled";
	private String temp_assignments = "Default Assignments";
	
	public Update_Group_Modal(WebDriver driver){
		this.driver = driver;
	}
	
	//return welcome message
	public String get_Group_Modal_Welcome(){
		return driver.findElement(updateGroupWelcome).getText();
	}
	//select and update the Participant Status and Template Assignment fields
	public void select_Group_Status(String part_status, String temp_assignments){
		this.part_status = part_status;
		this.temp_assignments = temp_assignments;
		driver.findElement(participantStatus).click();
		driver.findElement(participantStatus).sendKeys(part_status);
		driver.findElement(participantStatus).click();
		driver.findElements(templateAssignments).get(1).click();
		driver.findElements(templateAssignments).get(1).sendKeys(temp_assignments);
		driver.findElements(templateAssignments).get(1).click();
		driver.findElement(saveButton).click();
	}
	//return success message
	public String Bulk_Update_Status(){
		return driver.findElement(updateSuccess).getText();
	}
	//close modal
	public Bulk_Edit_Participants_Page close_Update_Group_Modal(){
		driver.findElement(doneButton).click();
		return new Bulk_Edit_Participants_Page(driver);
	}

}
