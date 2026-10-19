package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

import java.util.List;

public class CarritoCompras {

    public static WebElement ingresarCarritoCompras(WebDriver driver){

        return FactoryWebElements.initWithXpath(driver, "//a[@id='cartur']");
    }

    public static WebElement getNombreProductoCarrito(WebDriver driver){

        return FactoryWebElements.initWithXpath(driver, "//tbody[@id='tbodyid']//tr[@class='success']/td[2]");
    }

    public static WebElement getEliminarProducto(WebDriver driver, String producto) {

        return FactoryWebElements.initWithXpath(driver,"//tbody[@id='tbodyid']//tr[td[2][normalize-space()='" + producto + "']]//a[normalize-space()='Delete']");
    }

    public static WebElement getFilaProductoCarrito(WebDriver driver, String producto) {

        return FactoryWebElements.initWithXpath(driver,"//tbody[@id='tbodyid']//tr[td[2][normalize-space()='" + producto + "']]");
    }

    public static List<WebElement> getPreciosProductos(WebDriver driver) {
        return FactoryWebElements.initElementsWithXpath(driver, "//tbody[@id='tbodyid']/tr/td[3]");
    }

    public static WebElement getTotalCarrito(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//h3[@id='totalp']");
    }

    public static WebElement buttonPlaceOrder(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//button[@class='btn btn-success' and contains(text(), 'Place Order')]");
    }

    public static WebElement labelName(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='name' and contains(text(), 'Name')]");
    }

    public static WebElement labelCountry(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='country' and contains(text(), 'Country')]");
    }

    public static WebElement labelCity(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='city' and contains(text(), 'City')]");
    }

    public static WebElement labelCreditCard(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='card' and contains(text(), 'Credit card')]");
    }

    public static WebElement labelMonth(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='month' and contains(text(), 'Month')]");
    }

    public static WebElement labelYear(WebDriver driver){
        return FactoryWebElements.initWithXpath(driver, "//label[@for='year' and contains(text(), 'Year')]");
    }

    public static WebElement inputName(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='name']");
    }

    public static WebElement inputCountry(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='country']");
    }

    public static WebElement inputCity(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='city']");
    }

    public static WebElement inputCreditCard(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='card']");
    }

    public static WebElement inputMonth(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='month']");
    }

    public static WebElement inputYear(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//div[@id='orderModal']//input[@id='year']");
    }

    public static WebElement buttonPurchase(WebDriver driver) {
        return FactoryWebElements.initWithXpath(driver, "//button[contains(@class,'btn-primary') and contains(text(),'Purchase')]");
    }

    public static WebElement mensajeCompraExitosa(WebDriver driver, String MensajeCompraExitosa) {
        return FactoryWebElements.initWithXpath(driver, "//h2[contains(text(),'"+MensajeCompraExitosa+"')]");
    }

}
