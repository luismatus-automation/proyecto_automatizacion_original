@feature_sauce_demo
Feature: Ingreso Login SauceDemo

  @testLogin_saucedemo
  Scenario: Iniciar sesion con credenciales validas
    Given estoy en la web de "https://www.saucedemo.com/"
    When ingreso el username "standard_user"
    And ingreso el password "secret_sauce"
    And presiono el boton Login
    Then valido que me he logeado en el sitio correctamente

  Scenario: Rechazar el inicio de sesion con credenciales incorrectas
    Given estoy en la web de "https://www.saucedemo.com/"
    When ingreso el username "usuario_invalido"
    And ingreso el password "clave_invalida"
    And presiono el boton Login
    Then valido el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Validar el inicio de sesion con campos vacios
    Given estoy en la web de "https://www.saucedemo.com/"
    When presiono el boton Login
    Then valido el mensaje de error "Epic sadface: Username is required"