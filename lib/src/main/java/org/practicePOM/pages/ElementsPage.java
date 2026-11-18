package org.practicePOM.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ElementsPage extends BasePage {
    private final Locator textBoxMenuOption;
    public ElementsPage(Page page){
        super(page);
        this.textBoxMenuOption = page.getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("Text Box"));
    }
    public void clickTextBoxOptions(){
        textBoxMenuOption.click();
    }
}
