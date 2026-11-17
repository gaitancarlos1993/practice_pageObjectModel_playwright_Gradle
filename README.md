# Practice: Page Object Model (POM) & Responsive Testing con Playwright

Proyecto de práctica construido desde cero en **Java** utilizando **Playwright** y **Gradle**, enfocado en aplicar el patrón de diseño **Page Object Model (POM)** junto con validaciones de diseño **Responsive**, *media queries* y especificaciones visuales (tipografía y dimensiones tipo Figma) sobre [DemoQA](https://demoqa.com).

## Stack Tecnológico
* **Lenguaje:** Java 21 (LTS)
* **Automatización Web:** Microsoft Playwright for Java
* **Gestor de Construcción y Dependencias:** Gradle 8.10.2 (Groovy DSL)
* **Framework de Pruebas:** JUnit 5 (Jupiter)
* **Diagramación:** PlantUML (`docs/architecture.puml`)

---

## Estructura y Función de los Archivos

| Capa / Paquete | Archivo | Función Principal |
| :--- | :--- | :--- |
| **Documentación** | `docs/architecture.puml` | Diagrama UML que ilustra la herencia, dependencias y relaciones entre las clases del framework. |
| **Configuración** | `lib/build.gradle` | Define los plugins de Java, repositorios y dependencias (Playwright y JUnit 5). |
| **Configuración** | `config/ViewportSize.java` | `Enum` que centraliza las resoluciones de pantalla (`DESKTOP`, `TABLET`, `MOBILE`) para emular dispositivos. |
| **Utilidades** | `utils/StyleHelper.java` | Centraliza la lectura de estilos CSS computados (`font-size`, `color`), `BoundingBox` y validación de carga de imágenes. |
| **Pages (POM)** | `pages/BasePage.java` | Clase padre abstracta que comparte la instancia de `Page` y métodos comunes de navegación a todas las páginas. |
| **Pages (POM)** | `pages/HomePage.java` | Encapsula los localizadores y acciones de la página principal de DemoQA (tarjetas de módulos y banner superior). |
| **Pages (POM)** | `pages/TextBoxPage.java` | Encapsula el formulario de *Text Box* (inputs, botón de envío y panel de resultados) para pruebas funcionales. |
| **Test Base** | `base/BaseTest.java` | Gestiona el ciclo de vida de Playwright (`Browser` y `BrowserContext`) permitiendo que cada test elija su `ViewportSize`. |
| **Tests Funcionales** | `tests/functional/TextBoxTest.java` | Ejecuta flujos de usuario de extremo a extremo validando el funcionamiento correcto de los formularios sin exponer selectores. |
| **Tests Responsive** | `tests/responsive/HomeLayoutTest.java` | Audita *breakpoints*, cambio de grilla a diseño apilado en móvil, especificaciones tipográficas y dimensiones de imágenes. |

---

## Ejecución de Pruebas

Desde la raíz del proyecto, ejecuta en la terminal:

```bash
# En Windows (PowerShell / CMD)
.\gradlew test

# En Linux / macOS
./gradlew test
```
