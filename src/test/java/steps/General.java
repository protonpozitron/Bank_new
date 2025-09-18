package steps;

import adapters.WebDriverAccess;
import elements.Clickable;
import elements.Inputable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import types.Buttons;
import types.Fields;
import types.Header;
import types.Modals;
import utils.SaveCache;

import java.util.List;


public class General {
    SaveCache saveCache = new SaveCache(4);
 //   private WebDriverAccess adapter;
    WebDriver driver;
    Clickable clickIt ;
    Inputable field;
    Actions builder;
    public General(WebDriverAccess adapter) {
        this.driver=adapter.getDriverAccess();
        this.clickIt = new Clickable(driver);
        this.field = new Inputable(driver);
        this.builder = new Actions(driver);
    }


    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) {
        field.input(Fields.INPUT, name, value);
    }


    @И("^очистить поле \"([^\"]*)\"$")
    public void clearValue(String name) {
        field.clear(field.checkInputType(name), name);

    }

    @Тогда("поле ввода {string} пустое")
    public void isClear(String name) {
        field.isClear(Fields.INPUT, name);
    }

    @И("нажать кнопку {string}")
    public void click(String name) {
        clickIt.click(Buttons.BUTTON, name);
    }

    @И("нажать кнопку c лого {string}")
    public void clickLogo(String name) {
        clickIt.click(Buttons.LOGO, name);
    }

    @И("нажать на вкладку {string}")
    public void tabClick(String name) {
        clickIt.click(Buttons.TAB, name);
    }

    @И("нажать на ссылку {string}")
    public void linkClick(String name) {
        clickIt.click(Buttons.LINK, name);
    }

    @И("присутствует текст {string}")
    public void textIsDisplayed(String text) {
        clickIt.istextDisplayed(clickIt.isItCache(saveCache,text));
        // clickIt.istextDisplayed(clickIt.isItCache(text));
    }

    @И("в переменную {string} внести значение из колонки в {int} строке")
    public void saveValue(String text, Integer value) {
        saveCache.putCache(text, clickIt.getValue(Header.COLUMN, value));
    }

    @И("по {int} строке произвести клик")
    public void clickString(Integer value) {
        clickIt.click(Header.COLUMN, value.toString());
    }

    @И("проверить, что присутсвуют поля:")
    public void fieldsCheck(List<String> fields) {
        clickIt.selectValue(fields);
    }

    @И("по полю ввода {string} произвести клик")
    public void fieldsClick(String name) {
        clickIt.click(Fields.INPUT, name);
    }

    @И("проверить, что красная подсветка поля {string} присутствует")
    public void redCheck(String name) {
        clickIt.isDisplayed(Fields.INPUTERROR, name);
    }

    @И("присутствует модальное окно {string}")
    public void windowDisplayed(String name) {
        clickIt.isDisplayed(Modals.WINDOW, name);
    }

    @И("нажать клавишу {string}")
    public void pressKey(String name) {
        try {
           builder.sendKeys(clickIt.clickKey(name)).perform();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "document.dispatchEvent(new KeyboardEvent('keydown', {'key':'"+name+"'}));");
        }
   }
    @И("навести фокус на окно {string}")
    public void focusWindow(String name) {
        driver.switchTo().activeElement();
        //clickIt.click(Modals.WINDOW, name);
    }
}
