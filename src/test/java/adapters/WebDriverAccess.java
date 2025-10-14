package adapters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v137.network.Network;

import java.util.Optional;

public class WebDriverAccess {
    private ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    private ThreadLocal<DevTools> devTools = new ThreadLocal<>();

    public WebDriverAccess() {

    }
    /**
     * @param setDriver создает новый без указания локального браузера
     */
    public void setDriver() {
    driver.set(new ChromeDriver());
    }
    /**
     * @param getDriverAccess отдает созданный браузер(используется в Auth_Steps и General
     *                 для передачи значения браузера
     */
    public WebDriver getDriverAccess(){
        if (driver.get() == null) {

            setDriver();
        }
        return driver.get();
    }
    /**
     * * @param getDevTools() возвращает DevTools-сессию.
     */
    public DevTools getDevTools() {
        if (devTools.get() == null) {
            //Создание сессии
            DevTools tools = ((HasDevTools) getDriverAccess()).getDevTools();
            tools.createSession();
            //включается мониторинг сети
            tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            devTools.set(tools);
        }
        return devTools.get();
    }
    public void close() {
        if (driver.get() != null) {
            if (devTools.get() != null) {
                devTools.get().send(Network.disable());
                devTools.get().close();
                devTools.remove();
            }
            driver.get().quit();
            driver.remove();
        }
    }
}
