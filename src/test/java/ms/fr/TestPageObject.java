package ms.fr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestPageObject {
	WebDriver driver;
	String login = "j2ee";
	String pwd = "j2ee";
	String product_id = "FI-SW-02";
	int quantity = 2;
	
	@Before
	public void setUp() {
		driver = TechnicalTools.choixNav(ENavigators.Opera);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}

	//@Test
	public void testJpetstore01() {
		// accès à l'url de l'application
		driver.get("https://jpetstore.cfapps.io/catalog");
		
		// instanciation de la pageIndex
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		
		// appel de la méthode "clicSignInButton" --> instanciation de la page de connexion
		PageLogin page_login = page_index.clickSignIn(driver);
		
		// appel de la méthode "logIn" --> instanciation de la page d'accueil
		PageAccueil page_accueil = page_login.logIn(driver, login, pwd);
		assertTrue(page_accueil.signout_button.isDisplayed());
		assertEquals("Pas le bon message pour l'utilisateur", "ABC", page_accueil.message_accueil.getText());
		
		PageAnimal page_animal = page_accueil.selectionAnimal(driver, "fish");
		assertEquals("Fish", page_animal.titre_page_animal.getText());
		
		PageAnimalRace page_animal_race = page_animal.selectProduct(driver, product_id);
		
		PageShoppingCart page_shopping_cart = page_animal_race.clickAddCart(driver);
		assertEquals("Shopping Cart", page_animal.titre_page_animal.getText());
		
		page_shopping_cart.changementQuantite(quantity);
		
		double prix_total = TechnicalTools.conversionValeurChampPrix(page_shopping_cart.value_total);
		double prix_unitaire = TechnicalTools.conversionValeurChampPrix(page_shopping_cart.value);
		
		assertEquals("Le prix total n'est pas correct.", prix_unitaire, prix_total/2, 0.0);
	
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
		
		// accès à la page account + vérification
		PageAccount page_account = page_accueil.clickAccount(driver);
		assertEquals("Account Information", page_account.titre2.getText());
		
		//	changement de la langue préférentiel + vérification
		page_account.changeLanguage("Japanese");
		Select select_lang = new Select(page_account.select_language);
		assertEquals("Japanese", select_lang.getFirstSelectedOption().getText());
		
		// changement du type d'animal préféré . vérification
		page_account.changeFavAnimal("REPTILES");
		Select select_animal_fav = new Select(page_account.select_animal_fav);
		assertEquals("REPTILES", select_animal_fav.getFirstSelectedOption().getText());
		
		// vérification que les deux checkbox sont cochées
		assertTrue(page_account.checkbox_mylist.isSelected());
		assertTrue(page_account.checkbox_mybanner.isSelected());
		
		// on décoche la checkbox mylist + vérification
		page_account.changeCheckboxMyList();
		assertFalse(page_account.checkbox_mylist.isSelected());
	
	}
	
}