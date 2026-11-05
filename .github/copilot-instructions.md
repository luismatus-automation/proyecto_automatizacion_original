# Instrucciones para GitHub Copilot – Proyecto QA Automation

## 1. Contexto del proyecto

Este es un proyecto personal de QA Automation enfocado en pruebas automatizadas web y aprendizaje de buenas prácticas de automatización.

### Tecnologías y dependencias actuales

- Java 21.
- Maven.
- Selenium WebDriver 4.50.0.
- Cucumber Java 7.12.1.
- Cucumber JUnit 7.13.0.
- JUnit 4 (framework principal para las aserciones).
- JUnit Jupiter API 5.9.2 (dependencia existente, no asumir que se utiliza en las pruebas actuales).
- WebDriverManager 5.4.0.
- ExtentReports 4.1.3.
- ExtentReports Cucumber 4 Adapter 1.2.1.
- JSONPath 2.8.0.
- Gson 2.8.9.
- JSON Simple 1.1.1.
- Apache HttpClient y HttpMime 4.3.6.

IDE: IntelliJ IDEA.

Control de versiones: Git y GitHub.

Asistente de desarrollo: GitHub Copilot.

El archivo pom.xml contiene las dependencias actuales. Antes de proponer modificaciones, revisar su contenido.

## 2. Arquitectura del proyecto

Respetar la arquitectura actualmente implementada, basada en las siguientes capas:

- **Features:** contienen los escenarios de prueba escritos en Gherkin.
- **Definitions / Step Definitions:** conectan los pasos Gherkin con los métodos de los Page Objects y ejecutan las acciones sobre los elementos web.
- **Page Objects:** centralizan los localizadores y proporcionan métodos que retornan los WebElements correspondientes.
- **FactoryWebElements:** centraliza la búsqueda de elementos web y las esperas explícitas reutilizables.
- **Hooks / WebDriver:** gestionan la configuración, inicialización y cierre del navegador.

La arquitectura utiliza el patrón Page Object Model (POM).

IMPORTANTE: mantener la distribución actual de responsabilidades. No trasladar automáticamente las acciones de Selenium desde Step Definitions hacia Page Objects, ya que el proyecto actualmente ejecuta dichas acciones directamente desde los Step Definitions.

No cambiar la arquitectura sin analizar primero la implementación existente y explicar los motivos.

## 3. Estándares de programación

- Utilizar Java 21.
- Utilizar Maven para gestionar dependencias y ejecución.
- Mantener compatibilidad con Selenium 4 y Cucumber 7.
- Priorizar JUnit 4 en las pruebas actuales.
- Utilizar Assert de JUnit 4 para las validaciones.
- No introducir anotaciones ni aserciones de JUnit 5 en pruebas que utilizan JUnit 4.
- Utilizar nombres descriptivos para clases, métodos y variables.
- Mantener métodos pequeños y con responsabilidades definidas.
- Evitar duplicación de código.
- Priorizar código reutilizable, legible y mantenible.
- Respetar el estilo de programación existente.

## 4. Localizadores y elementos web

- Priorizar XPath, respetando el estilo actual del proyecto.
- Utilizar FactoryWebElements para localizar elementos.
- Preferir By cuando sea conveniente para permitir diferentes tipos de localizadores, como XPath, CSS o ID.
- Centralizar los localizadores dentro de sus respectivos Page Objects.
- Evitar XPath innecesariamente complejos.
- Evitar duplicar localizadores en diferentes clases.
- Los Page Objects deben proporcionar los WebElements a los Step Definitions mediante sus métodos correspondientes.

## 5. Esperas y sincronización

Priorizar esperas explícitas mediante WebDriverWait.

Evitar Thread.sleep().

Utilizar ExpectedConditions según la necesidad:

- presenceOfElementLocated: esperar que un elemento exista en el DOM.
- visibilityOfElementLocated: esperar que un elemento sea visible.
- elementToBeClickable: esperar que un elemento permita interacción.
- invisibilityOfElementLocated: esperar que desaparezca un elemento.

Las esperas genéricas y reutilizables deben estar en FactoryWebElements.

Las esperas específicas de una página o flujo deben estar en el Page Object correspondiente.

No agregar esperas innecesarias ni duplicar las que ya existen.

## 6. Responsabilidades por capa

### 6.1 Features

- Describir escenarios utilizando Gherkin.
- Mantener los pasos claros y orientados al comportamiento del usuario.
- Utilizar Given, When, Then y And según corresponda.
- Evitar incluir detalles técnicos de Selenium.
- Priorizar escenarios comprensibles y reutilizables.

### 6.2 Definitions / Step Definitions

Esta capa coordina la ejecución de los escenarios y contiene las acciones de interacción con los elementos web.

- Implementar los pasos definidos en los Features.
- Recibir los parámetros definidos en Gherkin.
- Invocar los métodos correspondientes de los Page Objects para obtener los WebElements.
- Ejecutar directamente las acciones de Selenium sobre los elementos retornados por los Page Objects.
- Permitir acciones como .sendKeys(), .click(), .clear() y otras interacciones de Selenium directamente en los Step Definitions.
- Realizar las validaciones mediante Assert de JUnit 4.
- Evitar definir localizadores XPath directamente en esta capa.
- Evitar realizar búsquedas de elementos directamente mediante driver.findElement() cuando exista un método correspondiente en los Page Objects.
- Mantener los pasos claros y ordenados.

### 6.3 Page Objects

- Centralizar los localizadores de cada página.
- Contener métodos que obtengan y retornen los WebElements correspondientes.
- Utilizar FactoryWebElements para localizar los elementos y gestionar las esperas.
- Mantener los métodos organizados y reutilizables.
- Evitar duplicar lógica existente en FactoryWebElements.
- No trasladar automáticamente las acciones .sendKeys() o .click() desde Step Definitions hacia Page Objects.
- Mantener el estilo actual de métodos y nomenclatura del proyecto.

### 6.4 FactoryWebElements

- Centralizar la búsqueda de elementos web.
- Gestionar esperas explícitas reutilizables.
- Proporcionar métodos genéricos para obtener elementos individuales y listas de elementos.
- Priorizar la reutilización de métodos.
- Evitar incorporar lógica específica de una página.
- Mantener compatibilidad con Selenium 4.

### 6.5 Hooks / WebDriver

- Respetar la gestión actual del navegador.
- No crear instancias adicionales del WebDriver sin necesidad.
- Mantener la configuración, inicialización y cierre del navegador de forma coherente con el proyecto.
- Revisar la implementación existente antes de proponer cambios.

## 7. Dependencias Maven

El pom.xml contiene las dependencias actuales del proyecto.

Antes de proponer una nueva librería:

1. Revisar si ya existe una dependencia que resuelva la necesidad.
2. Explicar por qué sería necesaria una nueva dependencia.
3. Evaluar su compatibilidad con Java 21 y las versiones actuales.
4. No modificar el pom.xml sin autorización.
5. No actualizar versiones automáticamente.

Actualmente existen dependencias de JUnit 4 y JUnit 5. Priorizar JUnit 4 para las pruebas actuales.

También existen versiones distintas de Cucumber Java y Cucumber JUnit. No modificar automáticamente esta diferencia.

Si se detectan conflictos o incompatibilidades entre dependencias, informar y explicar antes de proponer cambios.

## 8. Pruebas automatizadas

El proyecto contempla automatización web sobre diferentes aplicaciones:

- SauceDemo: pruebas de inicio de sesión, incluyendo escenarios positivos y negativos.
- Demoblaze: pruebas End-to-End (E2E), incluyendo flujos de navegación e interacción con funcionalidades del sitio.

Al implementar nuevas pruebas:

- Reutilizar la arquitectura existente.
- Revisar primero los escenarios y clases actuales.
- Identificar componentes y métodos reutilizables.
- Separar correctamente la descripción del escenario, la obtención de elementos y las acciones ejecutadas.
- Considerar escenarios positivos, negativos y alternativos.
- Priorizar pruebas que aporten cobertura funcional relevante.
- Evitar automatizar verificaciones innecesarias.

## 9. Uso de inteligencia artificial y GitHub Copilot

GitHub Copilot debe actuar como asistente de desarrollo y no reemplazar el criterio técnico.

Cuando genere código:

- Explicar brevemente qué hace y por qué se utiliza.
- Respetar la arquitectura existente.
- No generar código excesivamente complejo.
- No agregar dependencias innecesarias.
- No reemplazar clases existentes sin revisarlas.
- No modificar configuraciones sin autorización.
- Priorizar soluciones fáciles de comprender, mantener y reutilizar.
- Considerar el código existente antes de sugerir una implementación nueva.

El código generado debe ser comprensible para el desarrollador y permitir su mantenimiento posterior.

## 10. Forma de trabajo

Antes de implementar una nueva funcionalidad:

1. Revisar las clases existentes relacionadas con el cambio.
2. Comprender cómo funciona actualmente la arquitectura.
3. Identificar métodos reutilizables.
4. Respetar el estilo de programación existente.
5. Explicar qué archivos se modificarán y por qué.
6. Implementar únicamente los cambios necesarios.
7. Evitar modificar archivos que no estén relacionados con la solicitud.

Si existe una alternativa técnica mejor, explicarla antes de realizar cambios importantes.

**REGLA PRINCIPAL:**

Todo código nuevo debe integrarse coherentemente con la arquitectura actual del proyecto.

No reinventar la estructura, no trasladar responsabilidades automáticamente entre capas y no generar código innecesario.

La prioridad es mantener una automatización web organizada, reutilizable, comprensible y fácil de mantener.