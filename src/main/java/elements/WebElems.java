package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import types.Types;


public abstract class WebElems {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebElems(WebDriver driver) {
        this.driver = driver;

    }

    WebElement newtypeCheck(Types types, String name) {
        try {
            String elem = types.getTitle();
            return createElem(elem.replace("{{pattern}}", name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент не найден: " + name);
            return null;
        }
    }

    protected WebElement createElem(String path) {
        return driver.findElement(By.xpath(path));

    }

    public void isDisplayed(Types type, String name) {
        newtypeCheck(type, name).isDisplayed();
    }

    public void click(Types type, String name) {
        newtypeCheck(type, name).click();
    }

    ;
    public boolean istextDisplayed(String text) {
    return driver.findElement(By.linkText(text)).isDisplayed();
    }
    public String getCache(Types type, Integer value) {
        try {
            return newtypeCheck(type, value.toString()).getText();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент не найден в таблице");
            return null;
        }

    }

}
