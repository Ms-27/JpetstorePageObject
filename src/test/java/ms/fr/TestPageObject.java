package ms.fr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

public class TestPageObject {
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = TechnicalTools.choixNav(ENavigators.Opera);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
	// accès à l'url de l'application
	driver.get("https://jpetstore.cfapps.io/catalog");
	// instanciation de la pageIndex
	PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
	// appel de la méthode "clicSignInButton" --> instanciation de la page de connexion
	PageLogin page_login = page_index.clicSignInButton(driver);
	// appel de la méthode "logIn" --> instanciation de la page d'accueil
	PageAccueil page_accueil = page_login.logIn(driver,"j2ee", "j2ee");
	
	PageAnimal page_animal = page_accueil.clickAnimalButton(driver);
	
	PageAnimalRace page_animal_race = page_animal.clickAnimalRaceButton(driver);
	
	PageShoppingCart page_shopping_cart = page_animal_race.clickAddCart(driver);
	page_shopping_cart = page_shopping_cart.changementQuantite(driver, 2);
	
	System.out.println(page_shopping_cart.value);
	
	}
}