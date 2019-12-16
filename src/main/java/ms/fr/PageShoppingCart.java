package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageShoppingCart {
	@FindBy (xpath="//input[@id='lines0.quantity']") 
	private WebElement quantity_field;
	
	@FindBy (name="update") 
	private WebElement bouton_update;
	
	@FindBy (xpath="//tr[2]/td[7]/span") 
	WebElement value_total;
	
	@FindBy (xpath="//tr[2]/td[6]/span") 
	WebElement value;
	
	public PageShoppingCart changementQuantite(WebDriver driver, int i) {
		quantity_field.clear();
		String s = Integer.toString(i);
		quantity_field.sendKeys(s);
		bouton_update.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

}
