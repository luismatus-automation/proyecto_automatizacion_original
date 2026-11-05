package definitions.saucedemo;

import configs.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.saucedemo.LoginSouce;

public class LoginDefinitions {

    private final WebDriver driver = WebDriverManager.getDriver();

    @Given("estoy en la web de {string}")
    public void estoy_en_la_web_de(String url) {

        driver.get(url);

    }
    @When("ingreso el username {string}")
    public void ingreso_el_username(String userName) {

        LoginSouce.getInputUserName(driver).sendKeys(userName);

    }
    @When("ingreso el password {string}")
    public void ingreso_el_password(String password) {

        LoginSouce.getInputPassword(driver).sendKeys(password);

    }
    @When("presiono el boton Login")
    public void presiono_el_boton_login() {

        LoginSouce.getButtonSubmit(driver).click();

    }
    @Then("valido que me he logeado en el sitio correctamente")
    public void valido_que_me_he_logeado_en_el_sitio_correctamente() {

        Assert.assertTrue("No se mostró el inventario después del login",
                LoginSouce.getContainerInventario(driver).isDisplayed());
    }

    @Then("valido el mensaje de error {string}")
    public void valido_el_mensaje_de_error(String mensajeEsperado) {
        String mensajeObtenido = LoginSouce.getMensajeError(driver, mensajeEsperado).getText();
        Assert.assertEquals("El mensaje de validación no corresponde", mensajeEsperado, mensajeObtenido);
    }
}
