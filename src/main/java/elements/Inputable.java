package elements;

import org.openqa.selenium.WebDriver;
import types.Fields;
import types.Types;

import java.util.Arrays;


public class Inputable extends WebElems {

    public Inputable(WebDriver driver) {
        super(driver);
    }


    public void input(Types type, String name, String value) {
        try {
            newtypeCheck(type, name).sendKeys(value);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
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
            System.out.println("Поле " + name + " не найден на странице");
        }
        ;
    }

    public Types checkInputType(String name) {
        if (Fields.LOGPASSINPUT.getName().contains(name.toUpperCase())) {
            return Fields.LOGPASSINPUT;
        } else {
            return Fields.INPUT;
        }

    }


}
