package Hooks;
import adapters.WebDriverAccess;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {
    WebDriverAccess webDriverAccess;
    /**
     * @param setup создан для установки браузера,чтобы сработал параллельный запуск
     */
    @Before

    public void setup() {
       webDriverAccess.setDriver();

    }

    @After
    public void tearDown() {

        webDriverAccess.close();
    }
}
