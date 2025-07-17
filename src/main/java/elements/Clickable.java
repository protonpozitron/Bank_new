package elements;


import org.openqa.selenium.WebDriver;
import types.Types;

public class Clickable extends WebElems  {

  public Clickable (WebDriver driver) {
      super(driver);
  }

 @Override
    public void click(Types type, String name){
     newtypeCheck(type, name).click();
 }

}
