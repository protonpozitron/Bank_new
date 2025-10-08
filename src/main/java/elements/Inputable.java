package elements;

import generators.Gen;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.Fields;
import types.Types;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Inputable extends WebElems {
    Gen gen = new Gen();
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
        Matcher lit = Pattern.compile("!random\\(([a-zA-Z]+)(\\d+)\\)").matcher(value);
        boolean litFound = lit.find();
        if (value.contains("!random")) {
            String generateLit = lit.group(1);
            int num= Integer.parseInt(lit.group(2));
            switch (generateLit) {
                case "allSym":
                    e.sendKeys(gen.randomAll(num));
                    break;
                case "kir":
                    e.sendKeys(gen.randomStrKir(num));
                    break;
                case "lat":
                    e.sendKeys(gen.randomStrLat(num));
                    break;
                case "num":
                    e.sendKeys(gen.randomNum(num));
                    break;
            }
        } else {
            e.sendKeys(value);
        }
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

    public void clickAndPick(Types type, String name, String value) {
        try {
            newtypeCheck(type, name).click();
                List<WebElement> options = castWebToList(type, name);
            Thread.sleep(Duration.ofSeconds(5).toMillis());

            Iterator<WebElement> iter = options.iterator();
            while(iter.hasNext()) {
                WebElement we = iter.next();
                if (we.getText().equals(value)) {
                    we.click();
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            log.error("Значение " + value + " отсутствует");
            throw e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WebElement> castWebToList(Types type, String name){
        return newtypeCheck(type, name).findElements(By.tagName("li"));
    }

    public void countChar(Types type, String name, int value) {
        Assertions.assertEquals(newtypeCheck(type, name).getAttribute(name), value, "Содержимое поля " + name + " не равно " + value + " символам." + newtypeCheck(type, name).getText().length());

    }
}
