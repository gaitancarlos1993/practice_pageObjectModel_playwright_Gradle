package org.practicePOM.base;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.practicePOM.config.ViewportSize;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser(){
        Map<String, String> env = new HashMap<>();
        env.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
        //La linea 17 lo que hace es arrancar el proceso de Node.js de playwright y conectar con Java
        playwright = Playwright.create(new Playwright.CreateOptions().setEnv(env));
        browser = playwright.chromium().launch(
                //el setHeadless(false) es para poder observar la ejecución en directo
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setSlowMo(150)
        );
    }
    @AfterAll
    static void closeBrowser(){
        if (playwright != null){
            playwright.close();
        }
    }

    protected void initContext(ViewportSize viewport){
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(viewport.getWidth(), viewport.getHeight());
        //BrowserContext abre una ventana de incognito nueva y 100% limpia dentro del mismo navegador.
        //Esto nos permite ejecutar pruebas para desktop, mobile y otros devices
        context = browser.newContext(options);
        //Abre una nueva ventana dentro del contexto
        page = context.newPage();
    }
    //AfterEach se ejecuta en cada test individual e importante para no dejar muchas ventanas abiertas
    @AfterEach
    void closeContext(){
        if (context!= null){
            context.close();
        }
     }
}