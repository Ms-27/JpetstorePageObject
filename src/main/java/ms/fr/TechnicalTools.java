package ms.fr;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TechnicalTools {

	static WebDriver driver;

	static WebDriver choixNav(ENavigators n) {
		switch (n) {
		case Firefox:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver");
			driver = new FirefoxDriver();
			return driver;
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
			driver = new ChromeDriver();
			return driver;
		case Safari:
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
			return driver;
		case Opera:
			System.setProperty("webdriver.opera.driver", "src/main/resources/driver/operadriver");
			driver = new OperaDriver();
			return driver;
		default:
			return null;
		}
	}

	static void remplirChamp(WebElement w, String s) {
		w.clear();
		w.sendKeys(s);
	}

	static double conversionValeurChampPrix(WebElement w) {
		return Double.parseDouble(w.getText());
	}

//	public static int[] retournerNumeroDeLigne(String s) {
//		int[] tab_cell = { 1, 1 };
//		List<WebElement> liste_lignes = driver.findElements(By.xpath("table/tbody/tr"));
//		for (WebElement ligne : liste_lignes) {
//			List<WebElement> liste_colonnes = ligne.findElements(By.xpath("td"));
//			tab_cell[1] = 1;
//			for (WebElement colonne : liste_colonnes) {
//				if (colonne.getText().equals(s)) {
//					return tab_cell;
//				}
//				tab_cell[1]++;
//			}
//			tab_cell[0]++;
//		}
//		tab_cell[0] = -1;
//		tab_cell[1] = -1;
//		return tab_cell;
//	}

	public static int[] returnRowCol(String s) {
		// on initialise les coordonnées de notre cellule
		int[] cell = { 1, 1 };
		// on instancie la liste de ligne avec le xpath du tableau
		List<WebElement> list_row = driver.findElements(By.xpath("//table/tbody/tr"));
		// 1ere boucle qui balaye les lignes
		for (WebElement row : list_row) {
			// on instancie la liste des colonnes
			List<WebElement> list_col = row.findElements(By.xpath("td"));
			// on reset la valeur de colonne avant de balayer la ligne
			cell[1] = 0;
			for (WebElement col : list_col) {
				// on balaye chaque colonne en cherchant la correspondance de la cellule avec la
				// valeur s
				if (col.getText().equals(s)) {
					return cell;
				}
				// on incrémente la valeur de colonne
				cell[1]++;
			}
			// on incrémente la valeur de ligne
			cell[0]++;
		}
		// on
		cell[0] = -1;
		cell[1] = -1;
		return cell;
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

}
