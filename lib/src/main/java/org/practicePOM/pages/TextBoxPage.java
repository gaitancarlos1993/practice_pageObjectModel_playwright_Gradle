package org.practicePOM.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TextBoxPage extends BasePage {
    private final Locator FullNameInput;
    private final Locator emailInput;
    private final Locator currentAddressInput;
    private final Locator permanentAddressInput;
    private final Locator submitButton;
    private final Locator outputContainer;

    public TextBoxPage(Page page){
        //super(page) llama al constructor padre y le entrega el objeto page
        super(page);
        this.FullNameInput = page.locator("#userName");
        this.emailInput = page.locator("#userEmail");
        this.currentAddressInput = page.locator("#currentAddress");
        this.permanentAddressInput = page.locator("#permanentAddress");
        this.submitButton = page.locator("#submit");
        this.outputContainer = page.locator("#output");
    }

    public void fillAndSubmitForm(String fullName, String email, String currentAddress, String permanentAddress){
        FullNameInput.fill(fullName);
        emailInput.fill(email);
        currentAddressInput.fill(currentAddress);
        permanentAddressInput.fill(permanentAddress);
        //scrollIntoViewIfNeeded esto es en caso de que alguna propaganda o modal o contenedor o lo que sea no deje ver el boton
        submitButton.scrollIntoViewIfNeeded();
        submitButton.click();
    }
    public boolean isOutputVisible(){
        return outputContainer.isVisible();
    }
    public String getOutputText(){
        return outputContainer.textContent();
    }
}