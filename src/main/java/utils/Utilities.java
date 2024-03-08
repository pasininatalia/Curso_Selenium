package utils;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static enums.Browser.CHROME;

public class Utilities {

	public static WebDriver driver;

	private Utilities() {
	}

	public static WebDriver browser(Browser browser) {
		return switch (browser) {
			case CHROME -> new ChromeDriver();
			case FIREFOX -> new FirefoxDriver();
			case INTERNET_EXPLORER -> new InternetExplorerDriver();
			case SAFARI -> new SafariDriver();
		};
	}

	public static void createDriver() {
		driver = Utilities.browser(CHROME);
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
}