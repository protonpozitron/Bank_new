package adapters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverAccess {
    private ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    public WebDriverAccess() {

    }

    public void setDriver1() {
    driver.set(new ChromeDriver());
    }

    public WebDriver getDriverAccess(){
        if (driver.get() == null) {
            //      WebDriverManager.chromedriver().setup();
            //set(WebDriverFactory.createWebDriver("chrome")).;
            driver.set(new ChromeDriver());
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
