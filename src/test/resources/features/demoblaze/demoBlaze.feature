@feature_demoblaze
Feature: Ejercicios Practicos

#Criterios de Aceptacion ejercicios 1

#1.- Al ingresar al home de demoblaze deben poder visualizarse las categorias de: Phones, Laptops y Monitors.
#2.- Cada categoria debe mostrar como minimo 2 productos.
#3.- Cada categoria debe mostrar como máximo 9 productos
#4.- El titulo de la pestaña debe ser “STORE”
#5.- Al hacer click sobre un producto, el sitio debe llevarnos a la ficha de ese producto

# Ejercicio 1  ---------------------------------------------------------------------------------------------------------

  @ejercicio1_CA1
  Scenario: Validar categorias en DemoBlaze - Phones
    Given estoy en la web de "https://www.demoblaze.com/"
    Then valido que existe la categoria de "Phones"

  @ejercicio1_CA1
  Scenario: Validar categorias en DemoBlaze - Laptops
    Given estoy en la web de "https://www.demoblaze.com/"
    Then valido que existe la categoria de "Laptops"


  @ejercicio1_CA1
  Scenario: Validar categorias en DemoBlaze - Monitors
    Given estoy en la web de "https://www.demoblaze.com/"
    Then valido que existe la categoria de "Monitors"

# Ejercicio 2  ---------------------------------------------------------------------------------------------------------

  @ejercicio1_CA2
  Scenario: Validar que la categoria Phones no tiene menos de 2 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    Then valido que no existan menos de "2" productos

  @ejercicio1_CA2
  Scenario: Validar que la categoria Laptops no tiene menos de 2 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Laptops"
    Then valido que no existan menos de "2" productos

  @ejercicio1_CA2
  Scenario: Validar que la categoria monitor no tiene menos de 2 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Monitors"
    Then valido que no existan menos de "2" productos

# Ejercicio 3  ---------------------------------------------------------------------------------------------------------

  @ejercicio1_CA3
  Scenario: Validar que la categoria Phones no tiene mas de 6 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    Then valido que no existan mas de "9" productos

  @ejercicio1_CA3
  Scenario: Validar que la categoria Laptops no tiene mas de 6 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Laptops"
    Then valido que no existan mas de "9" productos

  @ejercicio1_CA3
  Scenario: Validar que la categoria monitor no tiene mas de 6 productos
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Monitors"
    Then valido que no existan mas de "9" productos

# Ejercicio 4  ---------------------------------------------------------------------------------------------------------

  @ejercicio1_CA4
  Scenario: Validar que el titulo de la pestana sea Store
    Given estoy en la web de "https://www.demoblaze.com/"
    Then valido que el nombre de la pestaña sea "STORE"

# Ejercicio 5  ---------------------------------------------------------------------------------------------------------

  #Al hacer click sobre un producto, el sitio debe llevarnos a la ficha de ese producto

  @ejercicio1_CA5
  Scenario: Validar que al ingresar a un producto su ficha es la correcta
    Given estoy en la web de "https://www.demoblaze.com/"
    When realizo click sobre el producto "Nexus 6"
    Then valido que la ficha corresponde a "Nexus 6"

#  ---------------------------------------------------------------------------------------------------------------------

#  Criterios de aceptación ejercicios 2
#1.-  Al añadir un producto al carrito e ingresar a este, se debe mostrar el producto recién añadido.
#2.-  El costo total del carrito debe coincidir con los productos añadidos en él.
#3.-  Al presionar “Place Order” debe mostrarse el formulario de compra.
#4.-  Al completar el formulario y presionar “Purchase” debe mostrarse el mensaje “Thank you for your purchase!”.


#Ejercicio 1  ----------------------------------------------------------------------------------------------------------

  @ejercicio2_CA1
  Scenario: Validar producto agregado al carrito - Samsung galaxy s6
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    And selecciono el producto "Samsung galaxy s6"
    And agrego el producto al carrito
    And ingreso al carrito de compras
    Then visualizo el producto "Samsung galaxy s6" en el carrito

#Ejercicio 2 CA5

  @ejercicio2_CA5
  Scenario: Validar que se puede eliminar un producto del carrito
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    And selecciono el producto "Samsung galaxy s6"
    And agrego el producto al carrito
    And ingreso al carrito de compras
    And elimino el producto "Samsung galaxy s6" del carrito
    Then confirmo que el producto fue eliminado del carrito

#Ejercicio 2  ----------------------------------------------------------------------------------------------------------

  @ejercicio2_CA2
  Scenario: Validar que el total del carrito coincida con los productos agregados
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    And selecciono el producto "Samsung galaxy s6"
    And agrego el producto al carrito
    And regreso a la pagina principal
    And ingreso a la categoria "Phones"
    And selecciono el producto "Nokia lumia 1520"
    And agrego el producto al carrito
    And ingreso al carrito de compras
    Then valido el costo total del carrito debe coincidir con la suma de los productos agregados

#Ejercicio 3  ----------------------------------------------------------------------------------------------------------

  @ejercicio2_CA3
  Scenario: Validar que se muestre el formulario de compra
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    And selecciono el producto "Samsung galaxy s6"
    And agrego el producto al carrito
    And regreso a la pagina principal
    And ingreso a la categoria "Phones"
    And selecciono el producto "Nokia lumia 1520"
    And agrego el producto al carrito
    And ingreso al carrito de compras
    And presiono el boton "Place Order"
    Then valido que aparezca el formulario con los siguientes campos

    |nombreCampo  |
    | Name        |
    | Country     |
    | City        |
    | Credit card |
    | Month       |
    | Year        |

#Ejercicio 4  ----------------------------------------------------------------------------------------------------------

  @ejercicio2_CA4
  Scenario: Validar compra exitosa
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso a la categoria "Phones"
    And selecciono el producto "Samsung galaxy s6"
    And agrego el producto al carrito
    And regreso a la pagina principal
    And ingreso a la categoria "Phones"
    And selecciono el producto "Nokia lumia 1520"
    And agrego el producto al carrito
    And ingreso al carrito de compras
    And presiono el boton "Place Order"
    And ingreso la siguiente informacion en el formulario
      | campo       | valor     |
      | Name        | Ignacio   |
      | Country     | Chile     |
      | City        | Santiago  |
      | Credit card | 123456789 |
      | Month       | 08        |
      | Year        | 2026      |
    And presiono el boton "Purchase"
    Then visualizo el mensaje "Thank you for your purchase!"


#  ---------------------------------------------------------------------------------------------------------------------

#  Ejercicio Outline
#Ejercicio 1
  @ejercicio_outline1
  Scenario Outline: Validar que al hacer click sobre productos se muestra su pagina
    Given estoy en la web de "https://www.demoblaze.com/"
    When realizo click sobre el producto "<Producto>"
    Then valido que la ficha corresponde a "<Producto>"

    Examples:
      | Producto          |
      | Samsung galaxy s6 |
      | Nexus 6           |
      | Sony xperia z5    |

#  ---------------------------------------------------------------------------------------------------------------------
#  Contact
  @test_contact
  Scenario: Envio formulario de contacto
    Given estoy en la web de "https://www.demoblaze.com/"
    When ingreso al menu de navegacion "Contact"
    And completo el formulario de contacto con los siguientes datos
      | campo         | valor                       |
      | Contact Email | qa.automation@example.com    |
      | Contact Name  | Ignacio                     |
      | Message       | Consulta de prueba          |
    And envio el formulario de contacto
    Then valido el mensaje de confirmacion de contacto "Thanks for the message!!"
