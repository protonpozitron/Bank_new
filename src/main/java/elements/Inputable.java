package elements;

import org.openqa.selenium.WebDriver;
import types.Types;


public class Inputable extends WebElems {

    public Inputable(WebDriver driver) {
        super(driver);
    }

    @Override
    void click(Types type, String name) {
        newtypeCheck(type, name).click();
    }



    public void input(Types type, String name, String value) {
        newtypeCheck(type, name).sendKeys(value);
    }

    public void clear(Types type, String name) {
        try {
            newtypeCheck(type, name).clear();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }

    }

    public void isClear(Types type, String name) {
        try {
            newtypeCheck(type, name).getText().isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Поле " + name + " заполнено.");
        } ;
    }



}
