package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAcceuil {
	@FindBy (xpath="//img[contains(@src, 'fish_icon.gif')]") 
	WebElement bouton_fish;
	
	public PageAnimal clickAnimalButton(WebDriver driver) {
		bouton_fish.click();
		return PageFactory.initElements(driver, PageAnimal.class);
	}

}
