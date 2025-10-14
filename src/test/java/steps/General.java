package steps;

import adapters.WebDriverAccess;
import elements.Clickable;
import elements.Inputable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.interactions.Actions;
import types.Buttons;
import types.Fields;
import types.Header;
import types.Modals;
import utils.SaveCache;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class General {
    public static SaveCache saveCache = new SaveCache(4);
    WebDriver driver;
    Clickable clickIt;
    Inputable field;
    Actions builder;
    DevTools devTools;
    private final AtomicReference<String> parameter = new AtomicReference<>();//для потокобезопасноcти
    public General(WebDriverAccess adapter) {
        this.driver = adapter.getDriverAccess();
        this.clickIt = new Clickable(driver);
        this.field = new Inputable(driver);
        this.builder = new Actions(driver);
        this.devTools = adapter.getDevTools();
    }


    @И("в поле ввода {string} ввести значение {string} с перехватом")
    public void inputValueNetwork(String name, String value) throws InterruptedException {
        sgetRequestetClickIt();
        field.input(Fields.INPUT, name, value);
        Thread.sleep(1500);
       saveCache.putCache("query", this.parameter.get());

    }

    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) throws InterruptedException {
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

    @И("нажать радиокнопку {string}")
    public void clickRadio(String name) {
        clickIt.click(Buttons.RADIO, name);
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
        clickIt.istextDisplayed(Header.LABEL, clickIt.isItCache(saveCache, text));
    }

    @И("в переменную {string} внести значение из колонки в {int} строке")
    public void saveValue(String text, Integer value) {
        saveCache.putCache(text, clickIt.getValue(Header.COLUMN, value));
    }

    @И("по {int} строке произвести клик")
    public void clickString(Integer value) {
        clickIt.click(Header.COLUMN, value.toString());
    }

    @И("проверить, что присутствуют поля:")
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
                    "document.dispatchEvent(new KeyboardEvent('keydown', {'key':'" + name + "'}));");
        }
    }

    @И("навести фокус на окно {string}")
    public void focusWindow(String name) {
        driver.switchTo().activeElement();
    }

    @Тогда("присутствует выпадающий список {string}")
    public void listIsDisplayed(String arg0) {
        field.isDisplayed(Fields.SELECTFIELD, arg0);

    }

    @И("в выпадающем списке {string} выбрать значение {string}")
    public void chooseValue(String arg0, String arg1) {
        field.clickAndPick(Fields.SELECTFIELD, arg0, arg1);
    }

    @Тогда("в поле {string} отображено {int} символов")
    public void countSymb(String arg0, int count) {

        String value = saveCache.getCache("query");
        System.out.println("Проверка значения из запроса: "+ value);
        Assertions.assertEquals(count,value.length());

    }

    public void sgetRequestetClickIt() {//пока для одного поля,потом сделаю
        devTools.addListener(Network.requestWillBeSent(), // cлушатель для события,которое происходит перед отправкой запроса
                requestSent -> {
                    String url = requestSent.getRequest().getUrl();
                    String urlEndPoint = "/suggest-by-name";

                    if (url.contains(urlEndPoint )) {
                        try {//слушатель для перехвата запроса
                            URI uri = new URI(url);//парсинг url
                            String queryString = uri.getQuery();//берем эндпоинт
                            if (queryString != null && queryString.contains("q=")) {
                                String value = URLDecoder.decode(queryString.split("q=")[1].split("&")[0],
                                        StandardCharsets.UTF_8.name());//декодирование значения
                                parameter.set(value);
                                System.out.println("Отобажение значения value "+value);
                                // saveCache.putCache("query",value);
                            }
                        } catch (Exception e) {

                        }
                    }
                });
    }

        @И("присутствует заголовок {string}")
        public void isItHeader (String text){
            clickIt.istextDisplayed(Header.HEADER, text);
        }
    }

