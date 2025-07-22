package steps;


import elements.Headers;
import elements.Inputable;
import io.cucumber.java.ru.И;
import types.Fields;
import types.Header;
import utils.SaveCache;
import utils.AuthReader;
import java.time.Duration;


public class Auth_Steps {
    SetUp setup;
    SaveCache saveCache = new SaveCache(4);

    Auth_Steps(SetUp setup) {
        this.setup =  new SetUp();
    }
    @И("открыта главная страница Интернет-банк")
    public void openBrowser() {
        setup.setup().manage().window().maximize();
        setup.setup().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setup.setup().get("https://idemo.bspb.ru/");
    }

    @И("авторизоваться в системе, заполнив поля {string}, {string}")
    public void newAuth(String login, String pass) {
        AuthReader reader = new AuthReader();
        new Inputable(setup.setup()).input(Fields.LOGPASSINPUT, login, reader.readAuth(login));
        new Inputable(setup.setup()).input(Fields.LOGPASSINPUT, pass, reader.readAuth(pass));
        System.out.println("Config " + reader.readAuth(login));

    }

    @И("подождать {int} секунд")
    public void waiting(int duration) {
        setup.setup().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    @И("открыта страница {string}")
    public void nameCheck(String name) {

        new Headers(setup.setup()).isDisplayed(Header.HEADER, name);

    }


}
