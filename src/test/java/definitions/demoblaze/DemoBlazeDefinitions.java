package definitions.demoblaze;

import configs.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demoblaze.CarritoCompras;
import pages.demoblaze.ContactDM;
import pages.demoblaze.HomeDM;
import pages.demoblaze.ProductosDM;
import utils.AceptarAlerta;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class  DemoBlazeDefinitions {

    private final WebDriver driver = WebDriverManager.getDriver();
    private WebElement filaProductoEliminada;

    @When("ingreso al menu de navegacion {string}")
    public void ingreso_al_menu_de_navegacion(String opcion) {

        HomeDM.getMenuNavegacion(driver, opcion).click();

        if (opcion.equals("Contact")) {
            ContactDM.getTituloModalContacto(driver, opcion);
        }
    }

    @When("completo el formulario de contacto con los siguientes datos")
    public void completo_el_formulario_de_contacto_con_los_siguientes_datos(DataTable dataTable) {

        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> fila : datos) {
            String campo = fila.get("campo");
            String valor = fila.get("valor");
            WebElement elemento;

            switch (campo) {
                case "Contact Email":
                    elemento = ContactDM.getEmailContacto(driver);
                    break;
                case "Contact Name":
                    elemento = ContactDM.getNombreContacto(driver);
                    break;
                case "Message":
                    elemento = ContactDM.getMensajeContacto(driver);
                    break;
                default:
                    throw new IllegalArgumentException("Campo de contacto no soportado: " + campo);
            }

            elemento.clear();
            elemento.sendKeys(valor);
        }
    }

    @When("envio el formulario de contacto")
    public void envio_el_formulario_de_contacto() {

        ContactDM.getBotonEnviarContacto(driver).click();
    }

    @Then("valido el mensaje de confirmacion de contacto {string}")
    public void valido_el_mensaje_de_confirmacion_de_contacto(String mensajeEsperado) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String mensajeObtenido = wait.until(ExpectedConditions.alertIsPresent()).getText();
        AceptarAlerta.aceptarAlerta(driver);

        Assert.assertEquals("El mensaje de confirmación de contacto no corresponde",
                mensajeEsperado, mensajeObtenido);

    }

    @Then("valido que existe la categoria de {string}")
    public void valido_que_existe_la_categoria_de(String categoria) {

        Boolean test = HomeDM.getCategoria(driver, categoria).isDisplayed();
        Assert.assertTrue("La categoría <<"+categoria+">>", test);
    }

    @When("ingreso a la categoria {string}")
    public void ingreso_a_la_categoria(String categoria) throws InterruptedException {

        HomeDM.getCategoria(driver, categoria).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid .card")));

    }
    @Then("valido que no existan menos de {string} productos")
    public void valido_que_no_existan_menos_de_productos(String cantidadMinima) {

        int cantidadProductos = HomeDM.getProductos(driver).size();

        Assert.assertTrue(
                "No deben existir menos de " + cantidadMinima + " productos",
                cantidadProductos >= Integer.parseInt(cantidadMinima)
        );
    }

    @Then("valido que no existan mas de {string} productos")
    public void valido_que_no_existan_mas_de_productos(String cantidadMaxima) {

        int cantidadProductos = HomeDM.getProductos(driver).size();

        Assert.assertTrue(
                "No deben existir mas de " + cantidadMaxima + " productos",
                cantidadProductos <= Integer.parseInt(cantidadMaxima)
        );

    }

    @Then("valido que el nombre de la pestaña sea {string}")
    public void valido_que_el_nombre_de_la_pestaña_sea(String tituloEsperado) {

        String tituloActual = HomeDM.getTitulo(driver);
        Assert.assertEquals(tituloEsperado, tituloActual);

    }

    @When("realizo click sobre el producto {string}")
    public void realizo_click_sobre_el_producto(String producto) {

        HomeDM.getProducto(driver, producto).click();

    }
    @Then("valido que la ficha corresponde a {string}")
    public void valido_que_la_ficha_corresponde_a(String productoEsperado) {

        String productoActual = ProductosDM.getNombreProducto(driver).getText();
        Assert.assertEquals(productoEsperado, productoActual);
    }
//--------------------------------------------------------------------------------------------

    // step definitions ejercicio2_CA1

    @When("selecciono el producto {string}")
    public void selecciono_el_producto(String producto) {

        HomeDM.getProducto(driver, producto).click();

    }
    @When("agrego el producto al carrito")
    public void agrego_el_producto_al_carrito() {

        ProductosDM.addProductoCarrito(driver).click();
        AceptarAlerta.aceptarAlerta(driver);

    }
    @When("ingreso al carrito de compras")
    public void ingreso_al_carrito_de_compras() {

        CarritoCompras.ingresarCarritoCompras(driver).click();

    }
    @Then("visualizo el producto {string} en el carrito")
    public void visualizo_el_producto_en_el_carrito(String productoEsperado) {

        String resultadoObtenido = CarritoCompras.getNombreProductoCarrito(driver).getText();
        Assert.assertEquals("El producto encontrado no corresponde", productoEsperado, resultadoObtenido);

    }

    @When("elimino el producto {string} del carrito")
    public void elimino_el_producto_del_carrito(String producto) {

        filaProductoEliminada = CarritoCompras.getFilaProductoCarrito(driver, producto);
        CarritoCompras.getEliminarProducto(driver, producto).click();
    }

    @Then("confirmo que el producto fue eliminado del carrito")
    public void confirmo_que_el_producto_fue_eliminado_del_carrito() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean filaEliminada = wait.until(ExpectedConditions.stalenessOf(filaProductoEliminada));
        Assert.assertTrue("La fila del producto todavía está presente en el carrito", filaEliminada);
    }

    // step definitions ejercicio2_CA2

    @When("regreso a la pagina principal")
    public void regreso_a_la_pagina_principal() {

        HomeDM.clickHome(driver).click();

    }
    @Then("valido el costo total del carrito debe coincidir con la suma de los productos agregados")
    public void valido_el_costo_total_del_carrito_debe_coincidir_con_la_suma_de_los_productos_agregados() {

        List<WebElement> precios = CarritoCompras.getPreciosProductos(driver);

        int sumaProductos = 0;

        for (WebElement precio : precios) {

            int valorPrecio = Integer.parseInt(precio.getText());

            sumaProductos = sumaProductos + valorPrecio;
        }

        int totalCarrito = Integer.parseInt(CarritoCompras.getTotalCarrito(driver).getText());

        Assert.assertEquals(sumaProductos, totalCarrito);

    }

    // step definitions ejercicio2_CA3

    @When("presiono el boton {string}")
    public void presiono_el_boton(String button) {

        if (button.equals("Place Order")) {
            CarritoCompras.buttonPlaceOrder(driver).click();
        }

        if (button.equals("Purchase")) {
            CarritoCompras.buttonPurchase(driver).click();
        }

    }

    @Then("valido que aparezca el formulario con los siguientes campos")
    public void valido_que_aparezca_el_formulario_con_los_siguientes_campos(DataTable dataTable) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='name' and contains(text(), 'Name')]")));

        List<String> campos = dataTable.asList();

        for (String campo : campos) {

            if (campo.equals("Name")) {
                Assert.assertTrue(CarritoCompras.labelName(driver).isDisplayed());
            }

            if (campo.equals("Country")) {
                Assert.assertTrue(CarritoCompras.labelCountry(driver).isDisplayed());
            }

            if (campo.equals("City")) {
                Assert.assertTrue(CarritoCompras.labelCity(driver).isDisplayed());
            }

            if (campo.equals("Credit card")) {
                Assert.assertTrue(CarritoCompras.labelCreditCard(driver).isDisplayed());
            }

            if (campo.equals("Month")) {
                Assert.assertTrue(CarritoCompras.labelMonth(driver).isDisplayed());
            }

            if (campo.equals("Year")) {
                Assert.assertTrue(CarritoCompras.labelYear(driver).isDisplayed());
            }
        }

    }

    @When("ingreso la siguiente informacion en el formulario")
    public void ingreso_la_siguiente_informacion_en_el_formulario(DataTable dataTable) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']//input[@id='name']")));

        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> fila : datos) {

            String campo = fila.get("campo");
            String valor = fila.get("valor");

            System.out.println("Campo: " + campo + " | Valor: " + valor);

            if (campo.equals("Name")) {
                CarritoCompras.inputName(driver).sendKeys(valor);
                Thread.sleep(1000);
            }

            if (campo.equals("Country")) {
                CarritoCompras.inputCountry(driver).sendKeys(valor);
                Thread.sleep(1000);
            }

            if (campo.equals("City")) {
                CarritoCompras.inputCity(driver).sendKeys(valor);
                Thread.sleep(1000);
            }

            if (campo.equals("Credit card")) {
                CarritoCompras.inputCreditCard(driver).sendKeys(valor);
                Thread.sleep(1000);
            }

            if (campo.equals("Month")) {
                CarritoCompras.inputMonth(driver).sendKeys(valor);
                Thread.sleep(1000);
            }

            if (campo.equals("Year")) {
                CarritoCompras.inputYear(driver).sendKeys(valor);
                Thread.sleep(1000);
            }
        }

    }
    @Then("visualizo el mensaje {string}")
    public void visualizo_el_mensaje(String mensajeEsperado) {

        String mensajeObtenido = CarritoCompras.mensajeCompraExitosa(driver, mensajeEsperado).getText();
        Assert.assertEquals("El mensaje obtenido no corresponde al esperado", mensajeEsperado, mensajeObtenido);

    }

}
