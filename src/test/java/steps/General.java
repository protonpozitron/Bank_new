package steps;


import elements.Clickable;
import elements.Inputable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import types.Buttons;
import types.Fields;


public class General  {
    SetUp setup;
    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) {
        new Inputable(setup.setup()).input(Fields.INPUT, name, value);
    }

    @И("^очистить поле \"([^\"]*)\"$")
    public void clearValue(String name) {
        try {
            Inputable inputable =new Inputable(setup.setup());
            inputable.clear(inputable.checkInputType(name),name);
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }

    @Тогда("поле ввода {string} пустое")
    public void isClear(String name) {
        new Inputable(setup.setup()).isClear(Fields.INPUT, name);

    }

    @И("нажать кнопку {string}")
    public void click(String name) {
        new Clickable(setup.setup()).click(Buttons.BUTTON, name);

    }

    @И("нажать кнопку c лого {string}")
    public void clickLogo(String name) {
        new Clickable(setup.setup()).click(Buttons.LOGO, name);

    }

    @И("нажать на вкладку {string}")
    public void tabClick(String name) {

        new Clickable(setup.setup()).click(Buttons.TAB, name);

    }

    @И("нажать на ссылку {string}")
    public void linkClick(String name) {

        new Clickable(setup.setup()).click(Buttons.LINK, name);

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
