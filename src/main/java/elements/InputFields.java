package elements;

import org.openqa.selenium.WebDriver;
import types.Types;


public class InputFields extends WebElems {
    //  protected final String pathInputField = ".//div[contains(text()," + field + ")] | .//span[contains(text()," + field + ")]";
//    protected final String logPassField = ".//input[contains(@placeholder,'"+field+"')]";
    //  protected final String inputRedError ="//label[normalize-space(.)='{{ value }}' ]/following::input[1 and @class[contains(.,'error')]]";

    public InputFields(WebDriver driver) {
        super(driver);
    }

    public void input(Types type, String name, String value) {
        String elem = InputCheck(type);
        createElem(elem.replace("{{pattern}}", name));
        web.sendKeys(value);
    }

    public void clear(Types type, String name) {
        try {
            String elem = InputCheck(type);
            createElem(elem.replace("{{pattern}}", name));
            web.clear();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Элемент " + name + " не найден на странице");
        }
        ;
    }

    public void isClear(Types type, String name) {
        String elem = InputCheck(type);
        createElem(elem.replace("{{pattern}}", name));
        try {
            web.getText().isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Поле " + name + " заполнено.");
        } ;
    }

    private String InputCheck(Types type) {
        return type.getTitle();

    }

}
