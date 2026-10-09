package pages.opencart;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class HomeOC {

    public static WebElement getItemMenuFooter(WebDriver driver, String item) {

        return FactoryWebElements.initWithXpath(driver,"//li//child::a[ text()='"+item+"']");
    }


}
