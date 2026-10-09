package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class ProductosDM {

    public static WebElement getNombreProducto(WebDriver driver) {

        return FactoryWebElements.initWithXpath(driver, "//h2[@class='name']");
    }

    public static WebElement addProductoCarrito(WebDriver driver){

        return FactoryWebElements.initWithXpath(driver, "//a[contains(@onclick,'addToCart') and normalize-space()='Add to cart']");
    }
}
