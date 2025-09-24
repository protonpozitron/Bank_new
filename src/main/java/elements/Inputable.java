package elements;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.Fields;
import types.Types;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Inputable extends WebElems {
    private static final Logger log = LoggerFactory.getLogger(Clickable.class);
    public Inputable(WebDriver driver) {
        super(driver);
    }

    public String getCache(Types type, Integer value) {

            return newtypeCheck(type, value.toString()).getText();

        }

    public void input(Types type, String name, String value) {
   WebElement e = newtypeCheck(type, name);
            e.click();
            e.sendKeys(value);

    }

    public void clear(Types type, String name) {
            newtypeCheck(type, name).clear();

    }

    public void isClear(Types type, String name) {

            newtypeCheck(type, name).getText().isEmpty();

    }

    public Types checkInputType(String name) {
        if (Fields.LOGPASSINPUT.getName().contains(name.toUpperCase())) {
            return Fields.LOGPASSINPUT;
        } else {
            return Fields.INPUT;
        }

    }

    public void clickAndPick(Types type, String name,String value) {
        try {
            newtypeCheck(type, name).click();
            Select select = new Select(newtypeCheck(type, name));
            select.selectByValue(value);
        } catch (IllegalArgumentException e) {
            log.error("Значение " + value + " отсутствует");
            throw e;
        }
    }

    public void countChar(Types type, String name,int value){
         Assertions.assertEquals(newtypeCheck(type, name).getText().length(),value,"Содержимое поля " + name + " не равно " + value + " символам.");

    }
}
