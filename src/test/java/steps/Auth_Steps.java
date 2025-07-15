package steps;


import elements.Headers;
import elements.InputFields;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import types.Types;
import utils.SaveCache;
import utils.AuthReader;

import java.io.IOException;
import java.time.Duration;





public class Auth_Steps {
    protected WebDriver driver;
    SaveCache saveCache = new SaveCache(4);

    @И("открыта главная страница Интернет-банк")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://idemo.bspb.ru/");
    }

    @И("авторизоваться в системе, заполнив поля {string}, {string}")
    public void newAuth(String login, String pass) throws IOException {
        try {
        AuthReader reader = new AuthReader();
        new InputFields(driver).input(Types.LOGPASSINPUT,login, reader.readAuth(login));
        new InputFields(driver).input(Types.LOGPASSINPUT,pass, reader.readAuth(pass));
        System.out.println("Config " + reader.readAuth(login));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент не найден на странице");
        }
    }

    @И("подождать {int} секунд")
    public void waiting(int duration) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }
    @И("открыта страница {string}")
    public void nameCheck(String name) {
        try {
            new Headers(driver).isDisplayed(Types.HEADER,name);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }



}
