package pages.demoblaze;

import org.junit.runner.manipulation.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

import java.util.List;


public class HomeDM {

    public static WebElement getCategoria(WebDriver driver, String categoria) {

        return FactoryWebElements.initWithXpath(driver,"//a[@id='itemc' and contains(text(), '"+categoria+"')]");
    }

    public static List<WebElement> getProductos(WebDriver driver) {

        return FactoryWebElements.initElementsWithXpath(driver,"//div[@class='card-block']");
    }

    public static String getTitulo(WebDriver driver) {
        return driver.getTitle();
    }

    public static WebElement getProducto(WebDriver driver, String producto) {

        return FactoryWebElements.initWithXpath(driver, "//a[@class='hrefch' and contains(text(), '"+producto+"')]");
    }

    public static WebElement clickHome(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver,"//a[@class='nav-link' and contains(text(), 'Home')]");
    }

    public static WebElement getMenuNavegacion(WebDriver driver, String opcion) {
        return FactoryWebElements.initWithXpath(driver,
                "//a[contains(@class, 'nav-link') and normalize-space()='" + opcion + "']");
    }

}