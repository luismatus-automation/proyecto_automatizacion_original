package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public static WebDriver driver;
    private static final String DEFAULT_BROWSER = "CHROME";

    public static WebDriver getDriver() {
        String browser = getBrowser();

        if (driver == null) {
            if ("CHROME".equalsIgnoreCase(browser)) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-features=PasswordLeakDetection");
                driver = new ChromeDriver(options);

            } else if ("MOZILLA".equalsIgnoreCase(browser)) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    private static String getBrowser() {
        String browser = System.getenv("BROWSER");
        if (browser == null || browser.trim().isEmpty()) {
            return DEFAULT_BROWSER;
        }
        return browser;
    }
}


