package steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SetUp {


    public WebDriver setup() {
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        return driver;
    }


}
