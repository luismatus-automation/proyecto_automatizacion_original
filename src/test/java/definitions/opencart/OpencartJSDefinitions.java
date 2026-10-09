package definitions.opencart;

import configs.WebDriverManager;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.opencart.HomeOC;

public class OpencartJSDefinitions {

    private final WebDriver driver = WebDriverManager.getDriver();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @When("realizo un scroll de {string} px;")
    public void realizo_un_scroll_de_px(String px) throws InterruptedException {

        js.executeScript("window.scrollBy(0,"+px+")");
        Thread.sleep(2000);

    }
    @When("realizo un click con JS sobre el elemento {string}")
    public void realizo_un_click_con_js_sobre_el_elemento(String item) throws InterruptedException {

        WebElement elemento = HomeOC.getItemMenuFooter(driver, item);
        js.executeScript("arguments[0].click();", elemento);
        Thread.sleep(3000);

    }
}
