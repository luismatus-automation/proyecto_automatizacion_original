# 🧪 Automatización de Pruebas E2E con Java, Selenium e IA

Framework personal de automatización de pruebas funcionales End-to-End (E2E) diseñado bajo buenas prácticas de ingeniería y arquitectura de software. Este proyecto valida flujos críticos de negocio en aplicaciones web de demostración (**SauceDemo** y **Demoblaze**) utilizando Desarrollo Guiado por Comportamiento (BDD) y asistencia de Inteligencia Artificial en el flujo de desarrollo.

---

## 🛠️ Stack Tecnológico y Herramientas

* **Lenguaje:** Java
* **Automatización Web:** Selenium WebDriver
* **BDD & Ejecución:** Cucumber (Gherkin) & JUnit
* **Patrón de Diseño:** Page Object Model (POM)
* **Gestor de Dependencias / Build:** Maven
* **Asistente de Desarrollo:** GitHub Copilot (flujo asistido por IA)
* **Control de Versiones:** Git & GitHub

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una separación clara de responsabilidades mediante el patrón **Page Object Model (POM)** para facilitar la escalabilidad y el mantenimiento del código:

proyecto_automatizacion_original/
├── src/
│   ├── main/java/          # Clases base, configuración de WebDriver y utilidades
│   └── test/
│       ├── java/
│       │   ├── pages/      # Page Objects (localizadores y acciones por página)
│       │   ├── steps/      # Step Definitions vinculados a los escenarios Gherkin
│       │   └── runners/    # Clases ejecutadoras de Cucumber / JUnit
│       └── resources/
│           └── features/   # Archivos .feature escritos en sintaxis Gherkin
├── pom.xml / build.gradle  # Gestión de dependencias del proyecto
└── README.md

✨ Características Principales
Diseño Declarativo con BDD: Escenarios funcionales legibles tanto para perfiles técnicos como de negocio utilizando Gherkin.

Sincronización Robusta: Implementación de esperas explícitas (WebDriverWait y ExpectedConditions) y estrategias de localizadores dinámicos (XPath/CSS) para evitar fallos intermitentes (flaky tests).

Validaciones Estrictas: Uso de aserciones en cada flujo crítico para garantizar la integridad funcional de extremo a extremo.

Cobertura Funcional:

SauceDemo: Autenticación de usuarios, validación de catálogo de productos, gestión de carrito de compras y flujo completo de checkout.

Demoblaze: Navegación por categorías, selección de productos, interacción con alertas del navegador y simulación de compra.

Desarrollo Potenciado con IA: Integración de GitHub Copilot para acelerar la generación de código repetitivo (boilerplate), refactorización y creación de casos de prueba, manteniendo revisión humana estricta antes de cada commit.

🚀 Requisitos Previos e Instalación
Requisitos:

Java JDK (versión 17 o superior recomendada).

Maven o Gradle instalado.

Navegador Google Chrome actualizado.

IDE recomendado: IntelliJ IDEA.

Clonar el repositorio: git clone [https://github.com/luismatus-automation/proyecto_automatizacion_original.git](https://github.com/luismatus-automation/proyecto_automatizacion_original.git)
cd proyecto_automatizacion_original

Ejecutar las pruebas:

Con Maven: mvn clean test

👨‍💻 Autor
Luis Matus

QA Automation Engineer | Especialista en Aseguramiento de Calidad y Sistemas Críticos

GitHub: @luismatus-automation
