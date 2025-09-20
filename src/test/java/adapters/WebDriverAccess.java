package adapters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverAccess {
    private ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    public WebDriverAccess() {

    }
    /**
     * @param setDriver создает новый без указания локального браузера
     */
    public void setDriver() {
    driver.set(new ChromeDriver());
    }
    /**
     * @param setDriver отдает созданный браузер(используется в Auth_Steps и General
     *                 для передачи значения браузера
     */
    public WebDriver getDriverAccess(){
        if (driver.get() == null) {
            setDriver();
        }
        return driver.get();
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
