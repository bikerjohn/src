package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Bulk_Edit_Participants_Page {
	WebDriver driver;
	By bulkEditPageWelcome = By.cssSelector("li[class='white bigger-150']");
	By selectTemplateAssignment = By.cssSelector("select[id='search.templateAssignment']");
	By selectAllCheckbox = By.cssSelector("input[id='editSelectAll']");
	By selectEditButton	= By.cssSelector("button[id='dataTableEdit']");
	By selectEditGroups = By.cssSelector("a[id='editGroupsModalTrigger']");
	By selectEditSchedule = By.cssSelector("a[id='editScheduleParticipantActivePeriodModalTrigger']");
	private String default_assignments = "Default Assignments";
	
	public Bulk_Edit_Participants_Page(WebDriver driver){
		this.driver = driver;
		
	}
	
	//return welcome text
	public String get_bulk_Edit_Welcome(){
		return driver.findElement(bulkEditPageWelcome).getText();
	}
	//select edit all checkbox
	public void select_Edit_All_Checkbox(){
		driver.findElement(selectAllCheckbox).click();
	}
	//select default template in template assignments column
	public void select_Default_Assignment_Column(String defaultassignments){
		this.default_assignments = defaultassignments;
		driver.findElement(selectTemplateAssignment).click();
		driver.findElement(selectTemplateAssignment).sendKeys(default_assignments);
		driver.findElement(selectTemplateAssignment).click();
	}
	//select Edit Button
	public void select_Edit_Button(){
		driver.findElement(selectEditButton).click();
	}
	//select Groups li under Edit Button (creates Bulk Update Group modal)
	public Update_Group_Modal select_Edit_Groups(){
		driver.findElement(selectEditGroups).click();
		return new Update_Group_Modal(driver);
	}
	//select Schedule li under Edit Button (creates Bulk Update Schedule modal)
	public Update_Schedule_Modal select_Edit_Schedule(){
		driver.findElement(selectEditSchedule).click();
		return new Update_Schedule_Modal(driver);
	}
	
}
