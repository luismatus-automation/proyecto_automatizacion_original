package pages.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

import java.util.List;

public class InventoryPage {

    public static List<WebElement> getProductNames(WebDriver driver) {
        return FactoryWebElements.initElementsWithXpath(driver, "//div[@data-test='inventory-item-name']");
    }

    public static List<WebElement> getProductPrices(WebDriver driver) {
        return FactoryWebElements.initElementsWithXpath(driver, "//div[@data-test='inventory-item-price']");
    }

    public static WebElement getSortDropdown(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//select[@data-test='product-sort-container']");
    }

    public static WebElement getAddProductButton(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver,
                "//button[@data-test='add-to-cart-sauce-labs-backpack']");
    }

    public static WebElement getRemoveProductButton(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver,
                "//button[@data-test='remove-sauce-labs-backpack']");
    }

    public static WebElement getCartBadge(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//span[@data-test='shopping-cart-badge']");
    }
}
