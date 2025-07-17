package elements;


import org.openqa.selenium.WebDriver;
import types.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Headers extends WebElems {

    public Headers(WebDriver driver) {
        super(driver);
    }

    @Override
    public void click(Types type, String name) {
        newtypeCheck(type, name).click();
    }

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
