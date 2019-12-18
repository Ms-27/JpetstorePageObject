package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAnimalRace extends PageAbstractMenu {
	@FindBy (xpath="//a[contains(@href, 'EST-3')][@class='Button']") 
	WebElement bouton_add_cart;
	
	@FindBy (xpath="//table//a[contains(., 'EST-')]")
	WebElement lien_item_tbl;
	
	public PageShoppingCart clickAddCart(WebDriver driver) {
		bouton_add_cart.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

}