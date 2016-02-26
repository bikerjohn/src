package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Card_Modal {
	WebDriver driver;
	By cardModalWelcome = By.cssSelector("div[class='widget-header']");
	By yesnoQuestion = By.cssSelector("a[href*='yesno']");
	By cardTitle = By.cssSelector("input[name='title']");
	By cardText = By.cssSelector("textarea[name='text']");
	By addButton = By.cssSelector("button[name='create']");
	private String CardTitle, CardText;
	
	public Card_Modal(WebDriver driver){
		this.driver = driver;
	}
		//Card Modal welcome message method
		public String getcarModalWelcome(){
	    return    driver.findElement(cardModalWelcome).getText();
	}
		public void selectYesNoQ (){
		driver.findElement(yesnoQuestion).click();
	}
		//create the Card by filling in the Title, description, and clicking the save button
		public Pilr_Survey_Builder createCard(String card_title, String text){
			this.CardTitle = card_title;
			this.CardText = text;
			setCard_Title(CardTitle);
			setCard_Text(CardText);
			driver.findElement(addButton).click();
			return new Pilr_Survey_Builder(driver);
		}
		//fill the Card Title field
		public void setCard_Title(String card_title){
		driver.findElement(cardTitle).sendKeys(card_title);
	}
		//fill the Card Text field
		public void setCard_Text(String text_description){
		driver.findElement(cardText).sendKeys(text_description);
	}
		
}
