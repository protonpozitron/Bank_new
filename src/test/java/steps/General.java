package steps;

import elements.Clickable;
import elements.Inputable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import types.Buttons;
import types.Fields;

public class General {
    protected WebDriver driver;

    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) {
            new Inputable(driver).input(Fields.INPUT, name, value);
    }

    @И("очистить поле {string}")
    public void clearValue(String name) {
        try {
            new Inputable(driver).clear(Fields.INPUT, name);
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
    public void textIsDisplayed(String name) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }

}
