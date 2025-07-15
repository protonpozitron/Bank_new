package steps;


import elements.InputFields;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import types.Types;

public class General
{
    protected WebDriver driver;
    @И("в поле ввода {string} ввести значение {string}")
    public void inputValue(String name, String value) {
        try {
            new InputFields(driver).input(Types.INPUT, name,value);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }

    @И("очистить поле ввода {string}")
    public void clearValue(String name) {
        try {
            new InputFields(driver).clear(Types.INPUT, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }
    @Тогда("поле ввода {string} пустое")
    public void isClear(String name){
        try {
            new InputFields(driver).isClear(Types.INPUT,name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
    }
}
