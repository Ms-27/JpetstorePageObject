package ms.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageShoppingCart extends PageAbstractMenu {
	@FindBy (xpath="//h2")
	WebElement titre;
	
	@FindBy (xpath="//input[@id='lines0.quantity']") 
	private WebElement quantity_field;
	
	@FindBy (name="update") 
	private WebElement bouton_update;
	
	@FindBy (xpath="//tr[2]/td[7]/span") 
	WebElement value_total;
	
	@FindBy (xpath="//tr[2]/td[6]/span") 
	WebElement value;
	
	public void changementQuantite(int i) {
		TechnicalTools.remplirChamp(quantity_field, Integer.toString(i));
		bouton_update.click();
	}

}
