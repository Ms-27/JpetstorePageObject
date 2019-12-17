package ms.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageAccount extends PageAbstractMenu {
	@FindBy (xpath="//form/div/h3")
	WebElement titre2;
	
	@FindBy (xpath="//select[@id='languagePreference']")
	WebElement select_language;
	
	@FindBy (xpath="//select[@id='favouriteCategoryId']")
	WebElement select_animal_fav;
	
	@FindBy (name="listOption")
	WebElement checkbox_mylist;
	
	@FindBy (name="bannerOption")
	WebElement checkbox_mybanner;
	
	public void changeLanguage(String s) {
		Select select = new Select(select_language);
		select.selectByValue(s);
	}
	
	public void changeFavAnimal(String s) {
		Select select = new Select(select_animal_fav);
		select.selectByValue(s);
	}
	
	public void changeCheckboxMyList () {
		checkbox_mylist.click();
	}
}
