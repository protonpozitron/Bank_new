package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import types.Types;



public abstract class WebElems {
    protected WebDriver driver = new ChromeDriver();
    protected WebElement web;

    public WebElems (WebDriver driver) {
        this.driver = driver;

    }
    WebElement newtypeCheck(Types types, String name) {
        try{
        String elem = types.getTitle();
        WebElement newElement =  createElem(elem.replace("{{pattern}}", name));
        return newElement;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент не найден: " + name);
            return null;
        }
    }

    protected WebElement createElem(String path){
       return driver.findElement(By.xpath(path));
    }
    public void isDisplayed(Types type, String name) {
        newtypeCheck(type, name).isDisplayed();
    }
    abstract void click(Types type, String name);

}
