package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAnimalRace {
	@FindBy (xpath="//a[contains(@href, 'EST-3')]") 
	WebElement bouton_add_cart;
	
	public PageShoppingCart clickAddCart(WebDriver driver) {
		bouton_add_cart.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

}
