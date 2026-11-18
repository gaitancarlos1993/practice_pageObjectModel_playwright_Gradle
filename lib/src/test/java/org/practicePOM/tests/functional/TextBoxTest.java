package org.practicePOM.tests.functional;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.practicePOM.base.BaseTest;
import org.practicePOM.config.ViewportSize;
import org.practicePOM.pages.HomePage;
import org.practicePOM.pages.TextBoxPage;
import org.practicePOM.pages.ElementsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TextBoxTest extends BaseTest{
    @Test
    void testFillTextBoxFormInDesktop(){
        initContext(ViewportSize.DESKTOP);
        HomePage homePage = new HomePage(page);
        TextBoxPage textBoxPage = new TextBoxPage(page);
        ElementsPage elementsPage = new ElementsPage(page);
        homePage.open();
        //Simula al usuario ingresando sobre la tarjeta Elements
        homePage.clickCategoryCard("Elements");
        elementsPage.clickTextBoxOptions();
        textBoxPage.fillAndSubmitForm(
                "Carlos Gaitan",
                "gaitancarlos1993@gmail.com",
                "Bogota, Colombia",
                "Calle Falsa 123"
        );
        assertTrue(textBoxPage.isOutputVisible(), "El cuadro de resultados debería mostrar tras enviar");
        String result = textBoxPage.getOutputText();
        assertTrue(result.contains("Carlos Gaitan"), "El resultado debe contener el nombre ingresado");
        assertTrue(result.contains("gaitancarlos1993@gmail.com"), "El resultado debe contener el correo ingresado");


    }
}
