package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SetUp {
    private static SetUp set;
    private WebDriver driver;

    SetUp() {

    }

    public static SetUp getInstance() {
        if (set == null) {
            set = new SetUp();
        }
        return set;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}


