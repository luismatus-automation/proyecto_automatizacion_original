package pages.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class HomeSouce {

    public static WebElement getInputUserName(WebDriver driver)
    {

       return FactoryWebElements.initWithXpath(driver,"//input[@placeholder='Username' ]");

    }

    public static WebElement getInputPassword(WebDriver driver)
    {

        return FactoryWebElements.initWithXpath(driver,"//input[@data-test='password' ]");

    }

    public static WebElement getButtonSubmit(WebDriver driver)
    {

        return FactoryWebElements.initWithXpath(driver,"//input[contains(@class, 'submit')]");

    }

    public static WebElement getContainerInventario(WebDriver driver)
    {

        return FactoryWebElements.initWithXpath(driver,"//div[@class='inventory_container']");
    }

    public static WebElement getMensajeError(WebDriver driver, String mensaje)
    {

        return FactoryWebElements.initWithXpath(driver,"//h3[@data-test='error' and contains(text(), '"+mensaje+"')]");
    }

}
