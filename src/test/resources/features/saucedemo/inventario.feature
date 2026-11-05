@feature_sauce_demo
Feature: Inventario de SauceDemo

  Background:
    Given estoy en la web de "https://www.saucedemo.com/"
    When ingreso el username "standard_user"
    And ingreso el password "secret_sauce"
    And presiono el boton Login
    Then valido que me he logeado en el sitio correctamente

  Scenario: Visualizar correctamente el listado de productos
    Then visualizo correctamente el listado de productos

  Scenario: Ordenar productos de A-Z
    When ordeno los productos de A-Z
    Then los productos se muestran ordenados de A-Z

  Scenario: Ordenar productos de Z-A
    When ordeno los productos de Z-A
    Then los productos se muestran ordenados de Z-A

  Scenario: Ordenar productos por precio de menor a mayor
    When ordeno los productos por precio de menor a mayor
    Then los productos se muestran ordenados por precio de menor a mayor

  Scenario: Ordenar productos por precio de mayor a menor
    When ordeno los productos por precio de mayor a menor
    Then los productos se muestran ordenados por precio de mayor a menor
  @inventario_sauce_demo
  Scenario: Agregar un producto al carrito
    When agrego un producto al carrito
    Then el contador del carrito muestra "1"
    And el producto muestra la opcion para eliminarlo del carrito

  Scenario: Eliminar un producto del carrito
    Given agrego un producto al carrito
    When elimino el producto del carrito
    Then el producto muestra la opcion para agregarlo al carrito
