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
	
	@FindBy(xpath = "//table[3]")
	WebElement tableau_Recherche;

	public int returnLineNumber(WebDriver driver, String s){ 
		int ligneCourante = 1;
		List<WebElement> liste_lignes = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(ligneCourante);
		for(WebElement ligne : liste_lignes) {
			List<WebElement> liste_cases = ligne.findElements(By.xpath("td"));
		   	if(liste_cases.get(1).getText().equals(s)){
			return ligneCourante;	
		   }
	      ligneCourante++;
		}
		return -1;	
	}
	
	public WebElement getCellule(WebDriver driver, int row, int col){ 
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+col+"]/a"));
		return element;
	}
	
	public PageAnimalRace clickCellule(WebDriver driver, String s) {
		int[] coord = TechnicalTools.returnRowCol(s);
//		System.out.println(coord[0]);
//		System.out.println(coord[1]);
		WebElement cellule = getCellule(driver, coord[0], coord[1]);
		cellule.click();
		return PageFactory.initElements(driver, PageAnimalRace.class);
	}
}
