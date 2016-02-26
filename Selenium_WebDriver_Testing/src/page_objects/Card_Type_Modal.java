package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card_Type_Modal {
	WebDriver driver;
	By cardModalWelcome = By.cssSelector("div[id*='addSurveyCardModal'] div[class='table-header']");
	By yesnoQuestion = By.cssSelector("a[href*='yesno']");
	
	public Card_Type_Modal(WebDriver driver){
		this.driver = driver;
	}
	//Card Modal welcome message method
	public String getcardModalWelcome(){
	       return    driver.findElement(cardModalWelcome).getText();
	}
	public Card_Modal selectYesNoQ (){
		driver.findElement(yesnoQuestion).click();
		return new Card_Modal(driver);
	}
}
