@feature_sauce_demo
Feature: Clase de localizadores

  @testLogin_saucedemo
  Scenario: Validar login en pagina de ejemplo
    Given estoy en la web de "https://www.saucedemo.com/"
    When ingreso el username "standard_user"
    And ingreso el password "secret_sauce"
    And presiono el boton Login
    Then valido que me he logeado en el sitio de ejemplo