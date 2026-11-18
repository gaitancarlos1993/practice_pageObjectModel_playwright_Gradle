package java.org.practicePOM.base;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.afterAll;
import org.junit.jupiter.api.afterEach;
import org.junit.jupiter.apì.BeforeAll;
import org.practicePOM.config.ViewportSize;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
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
        context = browser.newContext(options);
        page = context.newPage();
    }

    @AfterEach
    void closeContext(){
        if (context!= null){
            context.close();
        }
     }
}