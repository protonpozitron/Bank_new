package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class WebElems {
    protected WebDriver driver = new ChromeDriver();
    protected WebElement web;

    public WebElems (WebDriver driver) {
        this.driver = driver;
    }


    protected void createElem(String path){
       this.web = driver.findElement(By.xpath(path));
    }

}
