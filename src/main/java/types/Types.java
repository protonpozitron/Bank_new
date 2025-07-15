package types;

public enum Types {
    HEADER(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]"),

    LABEL(".//label[contains(text(),'{{pattern}}')]"),

    COLUMN(".//tr/td['{{pattern}}']/descendant::span[@class='alias']"),

    INPUT(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]"),

    LOGPASSINPUT(".//input[contains(@placeholder,'{{pattern}}')]"),

    INPUTERROR("//label[normalize-space(.)='{{pattern}}' ]/following::input[1 and @class[contains(.,'error')]]"),
    BUTTON(".//button[contains(.,'{{pattern}}')] | .//a[contains(.,'{{pattern}}')]"),
    LINK(".//div/a[contains(.,'{{pattern}}')] | .//a[contains(.,'{{ value }}')]/parent::li"),
    TAB(".//li[a[contains(.,'{{pattern}}')]]"),
    LOGO("//a[@id='logo']");
    private String title;

    Types(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
