package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageAbstractMenu {	
	@FindBy(xpath = "//a[contains(@href, '/login')]")
	protected WebElement signin_button;
	
	@FindBy(xpath = "//a[contains(@href, '/logout')]")
	protected WebElement signout_button;
	
	@FindBy(xpath = "//a[contains(@href,'account')]")
	protected WebElement account_button;
	
	public PageLogin clickSignIn(WebDriver driver) {
		signin_button.click();
		return PageFactory.initElements(driver, PageLogin.class);
	}
	
	public PageAccount clickAccount(WebDriver driver) {
		account_button.click();
		return PageFactory.initElements(driver, PageAccount.class);
	}

}
