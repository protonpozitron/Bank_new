package Hooks;
import adapters.WebDriverAccess;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {
    private final WebDriverAccess webDriverAccess;

    public Hooks(WebDriverAccess adapter) {
        this.webDriverAccess = adapter;
    }
    /**
     * @param setup создан для установки браузера,чтобы сработал параллельный запуск
     */
    @Before
    public void setup() {
       webDriverAccess.setDriver();
        webDriverAccess.getDevTools();

    }
    @After
    public void tearDown() {
        webDriverAccess.close();
    }
}
