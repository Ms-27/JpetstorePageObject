package ms.fr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestPageObject3 {
	WebDriver driver;
	String login = "j2ee";
	String pwd = "j2ee";
	String search_word = "fish";
	
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
	public void testJpetstore03() {
		// accès à l'application et connexion
		driver.get("https://jpetstore.cfapps.io/catalog");
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login = page_index.clickSignIn(driver);
		PageAccueil page_accueil = page_login.logIn(driver, login, pwd);
		assertTrue(page_accueil.signout_button.isDisplayed());
		assertEquals("Pas le bon message pour l'utilisateur", "ABC", page_accueil.message_accueil.getText());

		// accès page search avec la recherche <search_word> + vérification
		PageSearchResult page_searchresult = page_accueil.clickSearch(driver, search_word);
		assertTrue("Le tableau de résultat n'est pas présent", page_searchresult.th2.isDisplayed());
		
		// recherche dans le tableau et click sur le lien vers la page choix d'animal du
		PageAnimalRace page_animal_race = page_searchresult.clickCellule(driver, "Angelfish", 1);
//		assertTrue(page_animal_race.lien_item_tbl.isDisplayed());
		
//		PageSearchResult page_test = page_accueil.clickSearch(driver, search_word);;
//		WebElement cellule = page_test.getCellule(driver, 3, 3);
	}
	
}