@feature_JS
Feature: Ejercicio con JS

  @ejercicio1_JS
  Scenario: Validar scroll y click en https://opencart.abstracta.us/
    Given estoy en la web de "https://opencart.abstracta.us/"
    When realizo un scroll de "900" px;
    And realizo un click con JS sobre el elemento "About Us"