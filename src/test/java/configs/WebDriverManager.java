package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager
{
    public static WebDriver driver;

    private static final String BROWSER = "CHROME";

    public static WebDriver getDriver()
    {
        String BROWSER = getBrowser();

        if (driver == null)
        {
            if(BROWSER.equals("CHROME"))
            {
              //System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
              ChromeOptions options = new ChromeOptions();
              options.addArguments("--start-maximized");
              options.addArguments("--disable-features=PasswordLeakDetection");
              //options.addArguments("--window-size=1300,600");
              options.addArguments("--start-maximized");
              //options.addArguments("--headless");
              //options.addArguments("--no-sandbox");
              //driver = new ChromeDriver(options);
              //io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver(options);

            }
            else if(BROWSER.equals("MOZILLA"))
            {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
                //FireFoxOptions options = new FireFoxOptions();
                //options.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
        return driver;
        }

        private static String getBrowser()
        {
            String browser = null;
            browser = System.getenv("BROWSER");
            return browser;
        }

    }


