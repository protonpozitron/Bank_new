package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.Fields;
import types.Header;
import types.Types;

import java.util.List;

public class Clickable extends WebElems {

    private static final Logger log = LoggerFactory.getLogger(Clickable.class);

    public Clickable(WebDriver driver) {
        super(driver);
    }

    public void click(Types type, String name) {
        newtypeCheck(type, name).click();
    }

    public boolean istextDisplayed(String text) {
        //return driver.findElement(By.xpath(text)).isDisplayed();
        //      return driver.findElement(By.xpath(text)).isDisplayed();
        return newtypeCheck(Fields.INPUT, text).isDisplayed();

    }

    public boolean selectValue(List<String> fields) {
        boolean isDisp=true;
        for (String field : fields) {
            try {
                if (newtypeCheck(Header.LABEL, field).isDisplayed())
                {
                    log.info(("Поле " + field + " присутствует"));
                }else{
                    isDisp = false;
                }
            } catch (Exception e) {
                log.info(("Поле " + field + " отсутствует"));
                isDisp = false;
            }
        }
        return isDisp;
    }
    public CharSequence clickKey(String name) {
        try {
            switch (name) {
                case "ENTER":
                    return Keys.ENTER;
                case "SPACE":
                    return Keys.SPACE;
                case "ESCAPE":
                    return Keys.ESCAPE;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Кнопка отсутствует в методе");

        }

        return null;
    }

    public WebElement returnValue(Types type, String name) {
        return newtypeCheck(type, name);
    }
}
