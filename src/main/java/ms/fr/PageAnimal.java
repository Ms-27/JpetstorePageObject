package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAnimal {
	@FindBy (xpath="//a[contains(@href, 'FI-SW-02')]") 
	WebElement bouton_fish_sw02;
	
	public PageAnimalRace clickAnimalButton(WebDriver driver) {
		bouton_fish_sw02.click();
		return PageFactory.initElements(driver, PageAnimalRace.class);
	}

}
