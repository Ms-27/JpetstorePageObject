package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageAccount extends PageAbstractMenu {
	@FindBy (xpath="//form/div/h3")
	WebElement titre2;
	
	@FindBy (xpath="//select[@id='languagePreference']")
	WebElement select_language;
	
	@FindBy (xpath="//select[@id='favouriteCategoryId']")
	WebElement select_animal_pref;
	
	public PageAccount changeLanguage(WebDriver driver, String s) {
		Select select = new Select(select_language);
		select.selectByValue(s);
		return PageFactory.initElements(driver, PageAccount.class);
	}
}
