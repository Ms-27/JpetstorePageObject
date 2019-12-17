package ms.fr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAnimal extends PageAbstractMenu {
	@FindBy (xpath="//h2")
	WebElement titre_page_animal;
	
	public PageAnimalRace selectProduct(WebDriver d, String s) {
		d.findElement(By.xpath("//a[.='"+ s +"']")).click();;
		return PageFactory.initElements(d, PageAnimalRace.class);
	}

}
