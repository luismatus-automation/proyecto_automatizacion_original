package definitions.saucedemo;

import configs.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.saucedemo.InventoryPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventarioDefinitions {

    private final WebDriver driver = WebDriverManager.getDriver();

    @Then("visualizo correctamente el listado de productos")
    public void visualizo_correctamente_el_listado_de_productos() {
        List<WebElement> nombres = InventoryPage.getProductNames(driver);
        List<WebElement> precios = InventoryPage.getProductPrices(driver);

        Assert.assertEquals("La cantidad de productos del inventario no corresponde", 6, nombres.size());
        Assert.assertEquals("Cada producto debe mostrar su precio", nombres.size(), precios.size());
        for (int i = 0; i < nombres.size(); i++) {
            Assert.assertTrue("El nombre del producto debe estar visible", nombres.get(i).isDisplayed());
            Assert.assertFalse("El nombre del producto no debe estar vacío", nombres.get(i).getText().isEmpty());
            Assert.assertTrue("El precio del producto debe estar visible", precios.get(i).isDisplayed());
            Assert.assertFalse("El precio del producto no debe estar vacío", precios.get(i).getText().isEmpty());
        }
    }

    @When("ordeno los productos de A-Z")
    public void ordeno_los_productos_de_a_z() {
        new Select(InventoryPage.getSortDropdown(driver)).selectByValue("az");
    }

    @Then("los productos se muestran ordenados de A-Z")
    public void los_productos_se_muestran_ordenados_de_a_z() {
        List<String> nombresActuales = obtenerNombresProductos();
        List<String> nombresOrdenados = new ArrayList<>(nombresActuales);
        Collections.sort(nombresOrdenados, String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals("Los productos no están ordenados de A-Z", nombresOrdenados, nombresActuales);
    }

    @When("ordeno los productos de Z-A")
    public void ordeno_los_productos_de_z_a() {
        new Select(InventoryPage.getSortDropdown(driver)).selectByValue("za");
    }

    @Then("los productos se muestran ordenados de Z-A")
    public void los_productos_se_muestran_ordenados_de_z_a() {
        List<String> nombresActuales = obtenerNombresProductos();
        List<String> nombresOrdenados = new ArrayList<>(nombresActuales);
        nombresOrdenados.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        Assert.assertEquals("Los productos no están ordenados de Z-A", nombresOrdenados, nombresActuales);
    }

    @When("ordeno los productos por precio de menor a mayor")
    public void ordeno_los_productos_por_precio_de_menor_a_mayor() {
        new Select(InventoryPage.getSortDropdown(driver)).selectByValue("lohi");
    }

    @Then("los productos se muestran ordenados por precio de menor a mayor")
    public void los_productos_se_muestran_ordenados_por_precio_de_menor_a_mayor() {
        List<Double> preciosActuales = obtenerPreciosProductos();
        List<Double> preciosOrdenados = new ArrayList<>(preciosActuales);
        Collections.sort(preciosOrdenados);

        Assert.assertEquals("Los productos no están ordenados por precio ascendente",
                preciosOrdenados, preciosActuales);
    }

    @When("ordeno los productos por precio de mayor a menor")
    public void ordeno_los_productos_por_precio_de_mayor_a_menor() {
        new Select(InventoryPage.getSortDropdown(driver)).selectByValue("hilo");
    }

    @Then("los productos se muestran ordenados por precio de mayor a menor")
    public void los_productos_se_muestran_ordenados_por_precio_de_mayor_a_menor() {
        List<Double> preciosActuales = obtenerPreciosProductos();
        List<Double> preciosOrdenados = new ArrayList<>(preciosActuales);
        preciosOrdenados.sort(Collections.reverseOrder());

        Assert.assertEquals("Los productos no están ordenados por precio descendente",
                preciosOrdenados, preciosActuales);
    }

    @When("agrego un producto al carrito")
    public void agrego_un_producto_al_carrito() {
        InventoryPage.getAddProductButton(driver).click();
    }

    @Then("el contador del carrito muestra {string}")
    public void el_contador_del_carrito_muestra(String cantidadEsperada) {
        String cantidadActual = InventoryPage.getCartBadge(driver).getText();
        Assert.assertEquals("El contador del carrito no corresponde", cantidadEsperada, cantidadActual);
    }

    @Then("el producto muestra la opcion para eliminarlo del carrito")
    public void el_producto_muestra_la_opcion_para_eliminarlo_del_carrito() {
        Assert.assertTrue("El producto debería ofrecer la opción Remove",
                InventoryPage.getRemoveProductButton(driver).isDisplayed());
    }

    @When("elimino el producto del carrito")
    public void elimino_el_producto_del_carrito() {
        InventoryPage.getRemoveProductButton(driver).click();
    }

    @Then("el producto muestra la opcion para agregarlo al carrito")
    public void el_producto_muestra_la_opcion_para_agregarlo_al_carrito() {
        Assert.assertTrue("El producto debería ofrecer nuevamente la opción Add to cart",
                InventoryPage.getAddProductButton(driver).isDisplayed());
    }

    private List<String> obtenerNombresProductos() {
        List<String> nombres = new ArrayList<>();
        for (WebElement nombre : InventoryPage.getProductNames(driver)) {
            nombres.add(nombre.getText());
        }
        return nombres;
    }

    private List<Double> obtenerPreciosProductos() {
        List<Double> precios = new ArrayList<>();
        for (WebElement precio : InventoryPage.getProductPrices(driver)) {
            precios.add(Double.parseDouble(precio.getText().replace("$", "")));
        }
        return precios;
    }
}
