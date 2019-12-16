package ms.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageShoppingCart {
	@FindBy (name="lines[0].quantity") 
	WebElement quantity_field;
	
	@FindBy (name="update") 
	WebElement bouton_update;
	
	@FindBy (xpath="//tr[2]/td[6]/span") 
	WebElement value_total;
	
	@FindBy (xpath="//tr[2]/td[7]/span") 
	WebElement value;

}
