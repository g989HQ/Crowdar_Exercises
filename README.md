# Challenge | Automation

Este repositorio contiene un pequeño framework de automatización desarrollado en Java utilizando Selenium WebDriver y TestNG. El objetivo del framework es automatizar pruebas sobre las funcionalidades "Inicio de sesión" y "Agregado de productos al carrito de compras" de la web [Sauce Demo](https://www.saucedemo.com/).

## Requerimientos

- Java JDK 8 o superior.
- Maven (para la gestión de dependencias y la ejecución de pruebas).

## Instalación y Ejecución

1. Clonar este repositorio en su máquina local.

2. Abrir el proyecto en un IDE de Java compatible con Maven (por ejemplo, Eclipse, IntelliJ, etc.).

3. Actualizar el archivo `pom.xml` por si faltan dependencias (Presionando Save es suficiente).

4. Ejecutar las pruebas desde el archivo `testng.xml` ubicado en `Crowdar_Exercises/testrunner` haciendo clic derecho -> Run as -> TestNG suite.

## Resultados y Reporte

Para acceder al reporte de la ejecución, se tiene que abrir el archivo `index.html` ubicado en `Crowdar_Exercises/test-output`.

Del mismo modo, una vez terminada la ejecución, presione clic derecho sobre el proyecto y refrescarlo. Una vez hecho eso, debería aparecer la carpeta "Screenshot" con la captura del test fallido.

## Casos de Prueba

En el archivo `Crowdar_cases` se encuentran los casos de prueba escritos para validar los escenarios posibles de las funcionalidades "Inicio de sesión", "Agregado de productos al carrito de compras" y "Verificar Existencia de departamentos".

## Servicio Web - Mercado Libre

El framework también incluye una manera de interactuar con servicios web. Se ha agregado un caso de prueba adicional que realiza una solicitud GET al servicio de Mercado Libre para verificar la existencia de departamentos en la web [https://www.mercadolibre.com.ar/menu/departments](https://www.mercadolibre.com.ar/menu/departments).

## Notas Adicionales

- Las pruebas automatizadas se han diseñado para ejecutarse en Chrome (última versión) y Firefox (versión más reciente) para garantizar la compatibilidad en diferentes navegadores.
