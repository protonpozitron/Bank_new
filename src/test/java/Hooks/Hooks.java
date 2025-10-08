package Hooks;
import adapters.WebDriverAccess;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;


public class Hooks {
    WebDriverAccess webDriverAccess;
    BrowserMobProxy proxy = new BrowserMobProxyServer();
    /**
     * @param setup создан для установки браузера,чтобы сработал параллельный запуск
     */
    @Before

    public void setup() {
       webDriverAccess.setDriver();

        proxy.start(0);
    }

    @After
    public void tearDown() {

        webDriverAccess.close();
        proxy.stop();
    }
}
