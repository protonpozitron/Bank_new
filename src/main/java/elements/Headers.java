package elements;


import org.openqa.selenium.WebDriver;
import types.Types;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Headers extends WebElems {
//    protected final String pathHead = ".//div[contains(text(),'" + headtext + "')] | .//span[contains(text()," + headtext + ")]";
 //   protected final String label = ".//label[contains(text(),'" + headtext + "')]";
 //   protected final String columnValue = ".//tr/td['" + headtext + "']/descendant::span[@class='alias']";
   protected HashMap<String, String> elemPath = new HashMap<String, String>();

    public Headers(WebDriver driver) {
        super(driver);
    }

    public void isDisplayed(Types type, String name) {
        String elem =HeadersCheck(type);
        createElem(elem.replace("{{pattern}}", name));
        web.isDisplayed();
    }


    public String HeadersCheck(Types type) {
        return type.getTitle();

    }



    //createElem(".//div[contains(text()," + headtext +")] | .//span[contains(text()," + headtext +")]");
    //  driver.findElement(By.xpath(".//div[contains(text()," + headtext +")] | .//span[contains(text()," + headtext +")]"));
    //driver.findElement(By.xpath(".//div[contains(text()," + headtext +")] | .//span[contains(text()," + headtext +")]"));


    //new WebElems(driver.findElement(By.xpath(".//div[contains(text()," + headtext +")] | .//span[contains(text()," + headtext +")]"))) {};


    //   @FindBy(".//div[h1[contains(.,'{{ value }}')]]")
    //   AtlasWebElement header(@Param("value") String value);

//    @FindBy(".//label[contains(text(),'{{ value }}')]")
    //   AtlasWebElement label(@Param("value") String value);

    //   @FindBy(".//tr/td['{{ value }}']/descendant::span[@class='alias']")
    //   AtlasWebElement columnValue(@Param("value") String value);

    protected String ge1tValue(String sentence) {

        String s = ".//tr/td['" + sentence + "']/descendant::span[@class='alias']";
        Pattern p = Pattern.compile("(?:<span class=\"alias\">)([^\\)]*)(?:<\\/span>)");
        Matcher m = p.matcher(s);
        String temp = null;
        if (m.matches()) {
            temp = m.group(1);
        }
        return temp;

    }
}
