package ms.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserSelection {
	static WebDriver driver;

	static WebDriver browserSelector(EOS o, ENavigators n) {
		switch (o) {
		case MacOs:
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
			return driver;
		case Windows:
			return null;
		}
	}
}
