package ms.fr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestPageObject2 {
	WebDriver driver;
	String login = "j2ee";
	String pwd = "j2ee";
	
	@Before
	public void setUp() {
		driver = TechnicalTools.choixNav(ENavigators.Opera);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testJpetstore02() {
		// accès à l'application et connexion
		driver.get("https://jpetstore.cfapps.io/catalog");
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login = page_index.clickSignIn(driver);
		PageAccueil page_accueil = page_login.logIn(driver, login, pwd);
		assertTrue(page_accueil.signout_button.isDisplayed());
		assertEquals("Pas le bon message pour l'utilisateur", "ABC", page_accueil.message_accueil.getText());

		
	}
	
}