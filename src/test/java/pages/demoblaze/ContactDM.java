package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class ContactDM {

    public static WebElement getTituloModalContacto(WebDriver driver, String titulo) {
        return FactoryWebElements.initWithXpath(driver, "//a[@class='nav-link' and contains(text(), '"+ titulo +"')]");
    }

    public static WebElement getEmailContacto(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='exampleModal']//input[@id='recipient-email']");
    }

    public static WebElement getNombreContacto(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='exampleModal']//input[@id='recipient-name']");
    }

    public static WebElement getMensajeContacto(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='exampleModal']//textarea[@id='message-text']");
    }

    public static WebElement getBotonEnviarContacto(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver,
                "//div[@id='exampleModal']//button[normalize-space()='Send message']");
    }
}
