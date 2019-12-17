package ms.fr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends PageAbstractMenu{
	@FindBy (xpath="//div[@id='WelcomeContent']/div/span")
	WebElement message_accueil;
	
	public PageAnimal selectionAnimal(WebDriver d, String s) {
		d.findElement(By.xpath("//img[contains(@src, '"+ s +"_icon.gif')]")).click();;
		return PageFactory.initElements(d, PageAnimal.class);
	}

}
