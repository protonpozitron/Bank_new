package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.Fields;
import types.Types;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.openqa.selenium.Keys.*;

public class Clickable extends WebElems {

    private static final Logger log = LoggerFactory.getLogger(Clickable.class);

    public Clickable(WebDriver driver) {
        super(driver);
    }

    public void click(Types type, String name) {
        newtypeCheck(type, name).click();
    }

    public boolean istextDisplayed(String text) {

        return driver.findElement(By.xpath(text)).isDisplayed();
    }

    public boolean selectValue(List<String> fields) {
        boolean isDisp=true;
        for (String field : fields) {
            try {
                if (newtypeCheck(Fields.INPUT, field).isDisplayed())
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
    public Keys clickKey(String name) {
        try {
            switch (name) {
                case "ENTER":
                    return ENTER;
                case "SPACE":
                    return SPACE;
                case "ESCAPE":
                    return ESCAPE;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return null;
    }
}
