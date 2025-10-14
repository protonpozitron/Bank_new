package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.Types;
import utils.SaveCache;

import java.time.Duration;


public abstract class WebElems {
    protected WebDriver driver;
    protected WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    private static final Logger log = LoggerFactory.getLogger(Clickable.class);
    public WebElems(WebDriver driver) {
        this.driver = driver;

    }

    WebElement newtypeCheck(Types types, String name) {
        try{ String elem = types.getTitle();
            return waiter.until(ExpectedConditions.visibilityOf(createElem(elem.replace("{{pattern}}", name))));}
        catch (IllegalArgumentException e) {
            log.info("Элемент не найден: " + e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    protected WebElement createElem(String path) {
        try {
            return driver.
                    findElement(By.xpath(path));
        } catch (NoSuchElementException e) {
            log.info("Элемент не найден: " + e.getMessage());
            return null;
        }
    }



public void isDisplayed(Types type, String name) {
    newtypeCheck(type, name).isDisplayed();
}

public String getValue(Types type, Integer value) {
    try {

        return newtypeCheck(type, value.toString()).getText();
    } catch (NullPointerException e) {
        log.info("Элемент не найден в таблице"+ e.getMessage());
        return null;
    }
}

public String isItCache(SaveCache cache,String value) {
    if (value.contains("!cache")) {
        return cache.getCache(value.substring(7,(value.length() - 1)));
    } else return value;
}
}
