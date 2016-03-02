package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pilr_CoordinatePage {
	WebDriver driver;
	 
	   private String part_code = "992";
	   By coordinatePageWelcome = By.cssSelector("i.icon-double-angle-right");
	   By AddParticipant = By.id("addParticipant");
	   By ProjectInstrument = By.cssSelector("span.bigger-110");
	   By ViewGroups = By.id("navManagementGroupCategories");
	   By ParticipantDetail = By.id("show" + part_code);
	   By ProjectSettings = By.cssSelector("i[class='icon-cogs']");
	   By BrowseData = By.cssSelector("a[id='navDataBrowse']");
	   By BulkAddParticipant = By.cssSelector("a[id='bulkAddParticipant']");
	   By BulkEditParticipant = By.cssSelector("a[id='bulkEditParticipants']");
	   
	 public Pilr_CoordinatePage(WebDriver driver){
	 
	       this.driver = driver;
	   }
	   
	 	//Get the Coordinate Page Welcome
	    public String getcoordinatePageWelcome(){
	        return    driver.findElement(coordinatePageWelcome).getText();
	    }
	      
	    //Select the instrument text link
	    public Pilr_EMA_App_Home selectInstrument() {
	    	  driver.findElement(ProjectInstrument).click();
	    	  System.out.println("[Page Object]Select Instrument");
	    	  return new Pilr_EMA_App_Home(driver);
	    }	 
	    
	    //Select the browse data link
	    public Query_Project_Data browseData(){
	    	driver.findElement(BrowseData).click();
	    	return new Query_Project_Data(driver);
	    }
	    
	    //Select the add participant link
	    public Pilr_Create_Participant Create_Participant() {
	    	  driver.findElement(AddParticipant).click();
	    	  System.out.println("[Page Object]Add Participant");
	    	  return new Pilr_Create_Participant(driver);
	    }	
	    
	    //Select the view groups link
	    public Pilr_GroupPage selectViewGroups() {
	    	  driver.findElement(ViewGroups).click();
	    	  System.out.println("[Page Object]View Groups");
	    	  return new Pilr_GroupPage(driver);
	      }	
	    
	  //Build the participant link text using the TestVars part_code value
	  //Select the Participant Detail and return the new Participant Detail Page
	  public Pilr_ParticipantPage selectParticipant(String part_code) {
		  this.part_code = part_code;
		  this.ParticipantDetail = By.id("show"+part_code);
		  System.out.println("[Page Object]Select Participant Detail");
		  driver.findElement(ParticipantDetail).click();
		  return new Pilr_ParticipantPage(driver);
	   }	  
	  //select the project settings icon
	  public Project_Import_Modal selectProjectSettings(){
		  driver.findElement(ProjectSettings).click();
		  return new Project_Import_Modal(driver);
	  }
	  
	  //select the Bulk Add Participants action to launch bulk add participants page
	  public Bulk_Add_Participants_Page select_Bulk_Add_Participants(){
		  driver.findElement(BulkAddParticipant).click();
		  return new Bulk_Add_Participants_Page(driver);
	  }
	  
	  //select the Bulk Edit Participants option in the Action Group
	  public Bulk_Edit_Participants_Page select_Bulk_Edit_Participants(){
		  driver.findElement(BulkEditParticipant).click();
		  return new Bulk_Edit_Participants_Page(driver);
	  }
}
