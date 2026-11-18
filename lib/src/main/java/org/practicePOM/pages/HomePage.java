package org.practicePOM.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
//AriaRole viene de un concepto usado por discapacitados visuales rol semantico (ARIA), heading busca los enmcabezados
//Button los botones, TEXTBOX, las cajas de texto, LINK los hipervinculos
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage{
    private static final String URL = "https://demoqa.com/";
    private final Locator categoryCards;
    private final Locator headerBanner;
    public HomePage (Page page){
        super(page);
        this.categoryCards = page.locator(".category-cards .card");
        this.headerBanner = page.locator("header a img");

    }
    public void open(){
        navigateTo(URL);
    }
    public void clickCategoryCard(String categoryName){
        page.locator(".category-cards a",
                new Page.LocatorOptions().setHasText(categoryName)).click();
    }

    public int getCategoryCardsCount(){
        return categoryCards.count();
    }
    public Locator getCategoryCard(int index){
        return categoryCards.nth(index);
    }
    public Locator getHeaderBanner(){
        return headerBanner;
    }
}