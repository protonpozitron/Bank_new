package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import types.Fields;
import types.Types;


public class Inputable extends WebElems {

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


}
