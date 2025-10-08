package adapters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class WebDriverAccess {
    private ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    DevTools devTools;
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
    public DevTools getDevTools() {
        if (devTools == null) {
            devTools = driver.get().getDevTools();
        }
        return devTools;
    }
    public void close()
    {
        if (driver.get() == null)
        {
            driver.get().quit();
            driver.remove();
        }
    }
}
