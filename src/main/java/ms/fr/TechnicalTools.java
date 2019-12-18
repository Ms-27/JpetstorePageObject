package ms.fr;

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

}
