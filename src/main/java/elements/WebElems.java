package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import types.Types;

import java.time.Duration;


public abstract class WebElems {
    protected WebDriver driver;
    protected WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebElems(WebDriver driver) {
        this.driver = driver;

    }

    WebElement newtypeCheck(Types types, String name) {
        String elem = types.getTitle();
        return waiter.until(ExpectedConditions.visibilityOf(createElem(elem.replace("{{pattern}}", name))));

    }

    protected WebElement createElem(String path) {
        try {
            return driver.
                    findElement(By.xpath(path));
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден: " + e.getMessage());
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
        System.out.println(e.getMessage());
        System.out.println("Элемент не найден в таблице");
        return null;
    }

}

public String isItCache(String value) {
    if (value.contains("!cache")) {
        return value.substring(6);
    } else return value;
}
}
