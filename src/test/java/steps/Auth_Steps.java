package steps;
import elements.Headers;
import elements.Inputable;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import types.Fields;
import types.Header;
import utils.SaveCache;
import utils.AuthReader;
import java.time.Duration;


public class Auth_Steps {
  WebDriver driver= SetUp.getInstance().getDriver();


    @И("открыта главная страница Интернет-банк")
    public void openBrowser() {
        driver.get("https://idemo.bspb.ru/");
    }

    @И("авторизоваться в системе, заполнив поля {string}, {string}")
    public void newAuth(String login, String pass) {
        AuthReader reader = new AuthReader();
        new Inputable(driver).input(Fields.LOGPASSINPUT, login, reader.readAuth(login));
        new Inputable(driver).input(Fields.LOGPASSINPUT, pass, reader.readAuth(pass));
        System.out.println("Config " + reader.readAuth(login));

    }

    @И("подождать {int} секунд")
    public void waiting(int duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    @И("открыта страница {string}")
    public void nameCheck(String name) {

        new Headers(driver).isDisplayed(Header.HEADER, name);

    }


}
