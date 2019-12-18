package ms.fr;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchResult extends PageAbstractMenu {
	@FindBy (xpath="//table/tbody/tr/th[2]")
	WebElement th2;

	public int returnLineNumber(WebDriver driver, String s){ 
		int ligneCourante = 1;
		List<WebElement> liste_lignes = driver.findElements(By.xpath("//table/tbody/tr"));
		for(WebElement ligne : liste_lignes) {
			List<WebElement> liste_cases = ligne.findElements(By.xpath("td"));
		   	if(liste_cases.get(2).getText().equals(s)){
			return ligneCourante;	
		   }
	      ligneCourante++;
		}
		return -1;
	}
	
	public WebElement getCellule(WebDriver driver, int row, int col){ 
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+col+"]"));
		return element;
	}
	
	public PageAnimalRace clickCellule(WebDriver driver, String s, int col) {
		int row = returnLineNumber(driver, "Angelfish");
		WebElement cellule = getCellule(driver, row, col);
		cellule.click();
		return PageFactory.initElements(driver, PageAnimalRace.class);
	}
}
