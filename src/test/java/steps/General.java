package steps;

import elements.Clickable;
import elements.Headers;
import elements.Inputable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import types.Buttons;
import types.Fields;
import types.Header;
import utils.SaveCache;


public class General {
    SaveCache saveCache = new SaveCache(4);
    WebDriver driver = SetUp.getInstance().getDriver();

    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) {
        new Inputable(driver).input(Fields.INPUT, name, value);
    }

    @И("^очистить поле \"([^\"]*)\"$")
    public void clearValue(String name) {
        try {
            Inputable d = new Inputable(driver);
            new Inputable(driver).clear(d.checkInputType(name), name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }

    @Тогда("поле ввода {string} пустое")
    public void isClear(String name) {
        new Inputable(driver).isClear(Fields.INPUT, name);
    }

    @И("нажать кнопку {string}")
    public void click(String name) {
        new Clickable(driver).click(Buttons.BUTTON, name);
    }

    @И("нажать кнопку c лого {string}")
    public void clickLogo(String name) {
        new Clickable(driver).click(Buttons.LOGO, name);
    }

    @И("нажать на вкладку {string}")
    public void tabClick(String name) {
        new Clickable(driver).click(Buttons.TAB, name);
    }

    @И("нажать на ссылку {string}")
    public void linkClick(String name) {
        new Clickable(driver).click(Buttons.LINK, name);
    }

    @И("присутствует текст {string}")
    public void textIsDisplayed(String text) {
        try {
            new Headers(driver).istextDisplayed(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Текст " + text + " отсутствует на странице");
        }
    }

    @И("в переменную {string} внести значение из колонки в {int} строке")
    public void saveValue(String text, Integer value) {
        try {
            saveCache.putCache(new Headers(driver).getCache(Header.COLUMN, value));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Текст " + text + " отсутствует на странице");
        }
    }

    @И("по {int} строке произвести клик")
    public void clickString(Integer value) {
        new Headers(driver).click(Header.COLUMN, value.toString());
    }
}
