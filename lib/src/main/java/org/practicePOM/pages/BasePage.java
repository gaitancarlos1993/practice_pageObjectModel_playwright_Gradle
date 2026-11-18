package org.practicePOM.pages;
//Page es con quien interactuamos, es un objeto desestructurado que trae toda la informaciòn del DOM
import com.microsoft.playwright.Page;
//WaitUntilState es un enum propio de playwright donde esta definido el tiempo de espera
import com.microsoft.playwright.options.WaitUntilState;
//Abstract hace que una clase sea un molde incompleto, no se puede instanciar directamente sino que es una clase padre,
// donde otras clases heredaran de ella.
// Permite reutilizar comportamientos y atributos que todas las pantallas tienen en comun
public abstract class BasePage{
    protected final Page page;
    public BasePage(Page page){
        this.page = page;
    }
    public void navigateTo(String url){
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

    }
    //getCurrentUrl devuelve un string plano con la direcciòn web de la pantalla actual.
    public String getCurrentUrl(){
        return page.url();
    }
}