package types;

public enum Buttons implements Types{
    BUTTON(".//button[contains(.,'{{pattern}}')] | .//a[contains(.,'{{pattern}}')]"),
    LINK(".//div/a[contains(.,'{{pattern}}')] | .//a[contains(.,'{{ value }}')]/parent::li"),
    TAB(".//li[a[contains(.,'{{pattern}}')]]"),
    RADIO(".//span[contains(.,'{{pattern}}')]"),
    LOGO("//a[@id='logo']");
    private String title;

    Buttons(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
