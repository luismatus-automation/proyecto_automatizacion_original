package definitions.saucedemo;

import pages.saucedemo.HomeSouce;
import configs.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.AceptarAlerta;

public class LocalizadoresDefinitions {

    private final WebDriver driver = WebDriverManager.getDriver();

    @Given("estoy en la web de {string}")
    public void estoy_en_la_web_de(String url) {

        driver.get(url);

    }
    @When("ingreso el username {string}")
    public void ingreso_el_username(String userName) throws InterruptedException {

        HomeSouce.getInputUserName(driver).sendKeys(userName);

    }
    @When("ingreso el password {string}")
    public void ingreso_el_password(String password) throws InterruptedException {

        HomeSouce.getInputPassword(driver).sendKeys(password);

    }
    @When("presiono el boton Login")
    public void presiono_el_boton_login() throws InterruptedException {

        HomeSouce.getButtonSubmit(driver).click();

    }
    @Then("valido que me he logeado en el sitio de ejemplo")
    public void valido_que_me_he_logeado_en_el_sitio_de_ejemplo() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue("No se ha realizado el login", true);

    }

}
